package com.example.pawnbarianmockup.game;

/**
 * Creates enemy object, contains position
 * Need to implement attacks/hit detection
 *
 * @author Benni Trachtenberg
 * @version 11/26/2020
 */

public class Enemy extends Char
{
    private int health;
    
    public Enemy()                          // Enemy constructor
    {
        health=1;
    }

    public Enemy(int xpos, int ypos)
    {
        health = 1;
        moveTo(xpos,ypos);
    }

    public void setHealth(int amt)          // change the health of the enemy
    {
        health = amt;
    }

    public int getHealth()                  // returns the health of the enemy
    {
        return health;
    }
}
