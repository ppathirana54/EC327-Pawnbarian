

/**
 * Holds Position and Can Move
 *
 * @Priyan Pathirana
 * @1.0 b
 */
public class Char
{
    // instance variables - replace the example below with your own
    private int pos[]; 
    private String name; 
    final int INITIAL_STARTING_POS = 2;

    /**
     * Constructor for objects of class Char
     */
    public Char()
    {
        pos = new int[]{INITIAL_STARTING_POS,INITIAL_STARTING_POS};
        this.name = "Dummy";
    }
    
    public Char(String init_name)
    {
        pos = new int[]{INITIAL_STARTING_POS,INITIAL_STARTING_POS};
        this.name = init_name;
    
    }
    
    
    public Char(int xpos, Integer ypos, String init_name)
    {
        pos = new int[]{xpos,ypos};
        this.name = init_name;
    }
    
    public int[] getPos()
    {
        return pos;
    }

    public void moveTo(int x, int y)
    {
        pos[1] = x;
        pos[2] = y;
    }

    public void move(int x, int y)
    {
        pos[1] = pos[1] + x;
        pos[2] = pos[2] + y;
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
