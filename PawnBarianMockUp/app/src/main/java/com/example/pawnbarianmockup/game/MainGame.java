package com.example.pawnbarianmockup.game;

import java.util.Random;
import java.lang.Integer;
import java.util.ArrayList;
import static java.lang.Math.abs;

public class MainGame {

    protected Board board;

    //public ArrayList<Char> EnemyPos;

    public void NewGame(){
        board = new Board();
        restartRound();
    }

    public void restartRound()
    {
        int xpos;
        int ypos;
        Random rand = new Random();

        for(int i = 0; i < 3; i++)
        {
            xpos = rand.nextInt() % 5;
            ypos = rand.nextInt() % 5;

            board.makeEnemy(xpos, ypos);

        }
    }

    public int[][] getEnemyPos(){
        int enemynum = board.getNumberEnemies();
        int [][] Rarr = new int [enemynum][2];
        int []temp;
        for (int i = 0; i < enemynum; i++){
            temp = board.getEnemyPos(i);
            Rarr[i][0] = temp[0];
            Rarr[i][1] = temp[1];
        }
        return Rarr;
    }


    public void enemyTurn()
    {
        int [] enemyPos;
        int [] playerPos;
        int [] dir = {0,0};
        double magnitude;

        for(int i = 0; i < board.getNumberEnemies(); i++)
        {
            enemyPos = board.getEnemyPos(i);
            playerPos = board.getPlayerPosition();

            dir[0] =  Integer.signum(playerPos[0] - enemyPos[0]);
            dir[1] = Integer.signum(playerPos[1] - enemyPos[1]);

            board.moveEnemy(i,dir[0], dir[1]);
        }

    }

    public int damageCheck(int x, int y)
    {
        int [] enemyPos;

        for(int i = 0; i < board.getNumberEnemies(); i++)
        {
            board.checkDamage(x,y);
        }
        return 0;
    }

    // Draw and display cards


    public void captureCheck()
    {
        board.captureEnemy();
    }


//    public void playerTurn()
//    {
//        // Draw cards pick cards
//        if(board.)
//        board.movePlayer( // fill in variables here);
//
//        captureCheck();
//
//
//    }

    public boolean roundOver()
    {
        if(board.getNumberEnemies() == 0 || board.getPlayerHealth() == 0)
        {
            return true;
        }
        return false;
    }

}
