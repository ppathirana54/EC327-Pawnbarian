
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Char
{
    // instance variables - replace the example below with your own
    private int health;
    private int gold;
    //private cards deck[];

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        setName("Player");
        health = 3;
        gold = 0;
    }
    
    public void heal()
    {
        health++;
    }
    
    public void heal(int amt)
    {
        health = health + amt;
    }
    
    public void takeDamage()
    {
        health--;
    }
    
    public void takeDamage(int amt)
    {
        health = health - amt;
    }
    
    public void setHealth(int amt)
    {
        health = amt;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setWealth(int amt)
    {
        gold = amt;
    }
    
    public void getGold(int amt)
    {
        gold = gold + amt;
    }
    
    public int getWealth()
    {
        return gold;
    }

    
    
    
  
}
