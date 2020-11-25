/**
 * Creates the board class. Has a list of the number of enemies and creates a player. 
 * 
 * Need to implement alot tbh
 *
 */


import java.util.ArrayList;

public class Board
{
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private Player player;

    public Board()
    {
        player = new Player();
    }

    public int getNumEnemies()
    {
        return enemies.size();
    }

    public void makeEnemy(int x, int y)
    {
        enemies.add(new Enemy());
        enemies.get(getNumEnemies() - 1).moveTo(x,y);
    }

    public int[] getPlayerPosition()
    {
        return player.getPos();
    }

    public int[] getEnemyPosition(int enemynumber)
    {
        return enemies.get(enemynumber).getPos();
    }
    
    // deletes enemy that is captured
    public void capturedenemy()
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

    public int getNumberenemies() {
        return numberenemies;
    }



}
