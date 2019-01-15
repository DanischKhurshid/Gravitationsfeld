import javax.swing.JFrame;

/**
 * Main class that immediatly creates a gravitational field when class
 * is accessed.
 *
 * @author (Danisch, Mathilda, Emil)
 * @version (08.01.19)
 */
public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("gravitational field");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.add(new Space());
    }
}
