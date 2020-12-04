package com.example.pawnbarianmockup.game;

/**
 * Holds Position and Can Move
 * Complete!
 *
 * @Priyan Pathirana
 * @1.0 b
 */
public class Char
{
    // instance variables - replace the example below with your own
    private int pos[];
    private String name;
    final int INITIAL_STARTING_POSx = 2;
    final int INITIAL_STARTING_POSy = 1;

    /**
     * Constructor for objects of class Char
     */
    public Char()
    {
        pos = new int[]{INITIAL_STARTING_POSx,INITIAL_STARTING_POSy};
        this.name = "Dummy";
    }

    public Char(String init_name)
    {
        pos = new int[]{INITIAL_STARTING_POSx,INITIAL_STARTING_POSy};
        this.name = init_name;

    }

/*
    public Char(int xpos, int ypos, String init_name)
    {
        pos = new int[]{xpos,ypos};
        this.name = init_name;
    }
*/
    public int[] getPos()
    {
        return pos;
    }

    public void moveTo(int x, int y)
    {
        pos[0] = x;
        pos[1] = y;
    }

    public void move(int x, int y)
    {
        pos[0] = pos[0] + x;
        pos[1] = pos[1] + y;
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
