import java.util.ArrayList;

public class Board
{
    private ArrayList<Enemy> enimiesout = new ArrayList<Enemy>();
    private int numberenemies=0;
    private Player player;

    public Board()
    {
        player = new Player();
    }

    public void makeenemy(int x, int y)
    {
        enimiesout.add(new Enemy());
        numberenemies++;
        enimesout.get(numberenemies).moveTo(x,y);
    }

    public int[] getplayerposition()
    {
        return player.getPos();
    }

    public int[] getenemyposition(int enemynumber)
    {
        return enimesout.get(enemynumber).getPos();
    }
    
    // deletes enemy that is captured
    public void capturedenemy()
    {
        for (int i=0;i<numberenemies;i++)
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
