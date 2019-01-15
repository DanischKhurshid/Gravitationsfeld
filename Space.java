import javax.swing.JPanel;

import java.util.List;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 * Space class adds and visualize all planets.
 *
 * @author (Danisch, Mathilda, Emil)
 * @version (08.01.19)
 */
public class Space extends JPanel
{
    private ArrayList<Planet> planeten;

    public Space()
    {
        this.planeten = new ArrayList<>();
        this.setBackground(Color.WHITE);

        /*
        * When mouse is pressed a new planet is initialized
        * The new planet is added to the list of planets
        */
        addMouseListener(new MouseAdapter()
        {
          public void mousePressed(MouseEvent e)
          {
            planeten.add(new Planet(5, e.getX(), e.getY()));
          }
        });
    }

    public void paint(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // important for better rendering

        for (Planet planet : planeten)
        {
            planet.computeAttraction(planeten);

            // Draw planets to the Panel
            g2.setColor(Color.BLACK);
            g2.fill(planet.getPlanetCircle());
        }

        repaint(); // starts the method again
    }
}
