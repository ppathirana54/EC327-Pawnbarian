package com.example.pawnbarianmockup.game;

import static java.lang.Math.abs;

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
        setName("Skeleton");
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

    public boolean checkDamage(int xpos, int ypos)
    {
        int [] currPos = getPos();
        int x = xpos - currPos[0];
        int y = ypos - currPos[1];

        if (abs(x + y) == 1){
            return true;
        }
        else if ((abs(x) == 1 && abs(y) == 1)){
            return true;
        }
        return false;
    }
}
