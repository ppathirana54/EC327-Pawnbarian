package game;
/**
 * Creates the player object contains their position health and gold.
 * Need to implement card drawing/card moving
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class Player extends Char
{
    // instance variables - replace the example below with your own
    private int health;
    private int gold;
    private ArrayList<Cards> deck;
    private ArrayList<Cards> hand;
    private ArrayList<Cards> discard;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        setName("Player");
        health = 3;
        gold = 0;
        ArrayList<Cards> deck = new ArrayList<Cards>();
        ArrayList<Cards> hand = new ArrayList<Cards>();
        ArrayList<Cards> discard = new ArrayList<Cards>();

        Cards temp;
        for(int i = 0; i < 12; i++)
        {
            temp = new Cards(i%12);
            deck.add(temp);
        }

        Collections.shuffle(deck);

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

    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public void draw()
    {
        while(deck.size() < 3)
        {
            hand.add(deck.get(0));
            deck.remove(0);
        }
    }

    public void play(int card)
    {
        discard.add(hand.get(card));
        hand.remove(card);
    }

    public void restock()
    {
        while(discard.size() > 0)
        {
            deck.add(discard.get(0));
            discard.remove(0);
        }
    }

}
