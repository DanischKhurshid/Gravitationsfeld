import java.util.ArrayList;
import java.awt.geom.Ellipse2D;

/**
 * Planet class calculates his physical attraction to other plantes.
 *
 * @author (Danisch, Mathilda, Emil)
 * @version (08.01.19)
 */
public class Planet
{
    private double x;
    private double y;
    private double mass;
    private double xAccel;
    private double yAccel;
    private double xVelo;
    private double yVelo;
    private double xForce;
    private double yForce;

    /**
     * Planet gets a specific mass, x and y coordinate.
     * Set acceleration, velocity and force to 0.
     */
    public Planet(double mass, double x, double y)
    {
        this.mass = mass;
        this.x = x;
        this.y = y;

        this.xAccel = 0;
        this.yAccel = 0;
        this.xVelo = 0;
        this.yVelo = 0;
        this.xForce = 0;
        this.yForce = 0;
    }

    /**
     * Compute the attraction between all planets.
     * Determine acceleration, velocity and coordinates from planet.
     * Check if planets should collide.
     */
    public void computeAttraction(ArrayList<Planet> planeten)
    {
        
        for (Planet other : planeten) 
        {
            if (this != other) 
            {
                double xDistance = other.getX() - this.x;
                double yDistance = other.getY() - this.y;
                double r = Math.sqrt((xDistance) * (xDistance) + (yDistance) * (yDistance));
               
                double G = 6.67408*1e-8;
                double attraction_strength = (G * this.mass * other.mass)/(r*r);
                
                this.xForce += xDistance * attraction_strength;
                this.yForce += yDistance * attraction_strength;
                
                this.xAccel += this.xForce / this.mass;
                this.yAccel += this.yForce / this.mass;
                
                this.xVelo += this.xAccel;
                this.yVelo += this.yAccel;
                
                this.xAccel = 0;
                this.yAccel = 0;
                
                this.x += this.xVelo;
                this.y += this.yVelo;
            }
        }
    }

    /**
     * Increase the mass of own planet.
     * Remove the other planet, which collides.
     */
    public void computeCollision(ArrayList<Planet> planeten)
    {
        
    }

    /**
     * Declare and Initialize a circle for the planet, which is drawn into the Panel.
     */
    public Ellipse2D getPlanetCircle()
    {
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(this.x, this.y, this.x+this.getRadius(), this.y+this.getRadius());
        return circle;
    }

    /**
     * Getter and Setter Methods for data capsule
     */
    public int getRadius()
    {
       return (int) this.mass / 2;
    }
    public double getX()
    {
        return this.x;
    }
    public double getY()
    {
        return this.y;
    }
    public double getMass()
    {
        return this.mass;
    }

}
