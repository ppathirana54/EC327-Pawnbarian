package com.example.pawnbarianmockup.game;
/**
 * Creates the board class. Has a list of the number of enemies and creates a player.
 *
 * Need to implement alot tbh
 *
 */


import java.util.ArrayList;

public class Board
{
    // array list of enemies and player
    private ArrayList<Enemy> enemies;
    private Player player;


    public Board()                                              // board constructor
    {
        player = new Player();
        enemies =  new ArrayList<Enemy>();
    }

    public int getNumEnemies()                                 // returns number of enemies
    {
        return enemies.size();
    }

    public void makeEnemy(int x, int y)                        // makes a new enemy at location (x,y)
    {
        Enemy NEnemy = new Enemy();
        enemies.add(NEnemy);
        enemies.get(getNumEnemies() - 1).moveTo(x,y);
    }

    public int[] getPlayerPosition()                           // returns player position
    {
        return player.getPos();
    }

    public void movePlayer(int x, int y)
    {
        player.move(x,y);
    }

    public int[] getEnemyPosition(int enemynumber)             // returns position of enemy number enemynumber
    {
        return enemies.get(enemynumber).getPos();
    }

    public int getPlayerHealth()
    {
        return player.getHealth();
    }

    public void captureEnemy()                                // deletes enemy that is captured
    {
        for (int i=0;i<getNumEnemies();i++)
        {
            if (getPlayerPosition()[0]==getEnemyPosition(i)[0] && getPlayerPosition()[1]==getEnemyPosition(i)[1])
            {
                enemies.remove(i);
                break;
            }
        }
    }

    public int checkDamage(int x, int y)
    {
        int totalDamage = 0;
        for(int i = 0; i < getNumberEnemies(); i++)
        {
            if(enemies.get(i).checkDamage(x,y))
            {
                totalDamage++;
            }
        }

        return totalDamage;
    }

    public int getNumberEnemies() {                            // returns the number of enemies out
        return enemies.size();
    }

    public int[]  getEnemyPos(int i)
    {
        return enemies.get(i).getPos();
    }

    public void moveEnemy(int i, int xpos,int ypos)
    {
        enemies.get(i).move(xpos,ypos);
    }



}




