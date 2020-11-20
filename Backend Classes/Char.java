

/**
 * Holds Position and Can Move
 *
 * @Priyan Pathirana
 * @1.0 b
 */
public class Char
{
    // instance variables - replace the example below with your own
    private double pos[]; 
    private String name; 

    /**
     * Constructor for objects of class Char
     */
    public Char()
    {
        pos = new double[]{3,3};
        this.name = "Dummy";
    }
    
    public Char(String init_name)
    {
        pos = new double[]{3,3};
        this.name = init_name;
    
    }
    
    
    public Char(double xpos, double ypos, String init_name)
    {
        pos = new double[]{xpos,ypos};
        this.name = init_name;
    }
    
    public double[] getPos()
    {
        return pos;
    }

    public void move(double x, double y)
    {
        pos[1] = x;
        pos[2] = y;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        name = newName;
    }
    
    
}
