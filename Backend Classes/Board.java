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
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private Player player;

    public Board()                                              // board constructor
    {
        player = new Player();
    }

    public int getNumEnemies()                                 // returns number of enemies
    {
        return enemies.size();
    }

    public void makeEnemy(int x, int y)                        // makes a new enemy at location (x,y)
    {
        enemies.add(new Enemy());
        enemies.get(getNumEnemies() - 1).moveTo(x,y);
    }

    public int[] getPlayerPosition()                           // returns playes position
    {
        return player.getPos();
    }

    public int[] getEnemyPosition(int enemynumber)             // returns position of enemy number enemynumber
    {
        return enemies.get(enemynumber).getPos();
    }
    
    public void capturedenemy()                                // deletes enemy that is captured
    {
        for (int i=0;i<getNumEnemies();i++)
        {
            if (getplayerposition()[0]==getenemyposition(i)[0] && getplayerposition()[1]==getenemyposition(i)[1])
            {
                enimesout.remove(i);
                break;
            }
        }
    }

    public int getNumberenemies() {                            // returns the number of enemies out 
        return numberenemies;
    }



}
