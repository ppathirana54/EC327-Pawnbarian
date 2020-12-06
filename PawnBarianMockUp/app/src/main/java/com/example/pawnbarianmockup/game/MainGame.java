package com.example.pawnbarianmockup.game;

import android.os.Build;
import android.text.style.ReplacementSpan;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.pawnbarianmockup.R;

import java.util.Hashtable;
import java.util.Random;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.abs;

public class MainGame {

    protected Board board;

    private Hashtable<Integer, Character> int_to_char = new Hashtable<Integer, Character>();


    //public ArrayList<Char> EnemyPos;

    public void NewGame(){
        board = new Board();
        restartRound();
    }

    public void restartRound()
    {
        int xpos;
        int ypos;
        //Random rand = new Random();
        board.makeEnemy(2, 5);
        //board.makeEnemy(0, 4);
        //board.makeEnemy(4, 4);

/*
        for(int i = 0; i < 3; i++)
        {
            xpos = rand.nextInt() % 5;
            ypos = rand.nextInt() % 5;

            board.makeEnemy(xpos, ypos);

        } */
    }

    public int[][] getEnemyPos(){
        int enemynum = board.getNumberEnemies();
        int [][] Rarr = new int [enemynum][2];
        int []temp;
        temp = board.getEnemyPos(0);
        Rarr[0][0] = temp[0];
        Rarr[0][1] = temp[1];
        /*for (int i = 0; i < enemynum; i++){
            temp = board.getEnemyPos(i);
            Rarr[i][0] = temp[0];
            Rarr[i][1] = temp[1];
        } */
        return Rarr;
    }

    public void PlayerTurn(int []Posi){
        board.movePlayer(Posi[0], Posi[1]);
    }

/*
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
*/
    public int[] enemyTurn(int []EnemyPos, int []PlayerPos){
        int []Pos = new int[2];
        Pos[0] = EnemyPos[0] - PlayerPos[0];
        Pos[1] = EnemyPos[1] - PlayerPos[1];

        if (Pos[0] == 0 && Pos[1] != 0){
            Pos[0] = EnemyPos[0];
        }
        else if (Pos[0] > 1){
            Pos[0] = EnemyPos[0] - 1;
        }
        else if (Pos[0] < -1){
            Pos[0] = EnemyPos[0] + 1;
        }
        else{
            Pos[0] = EnemyPos[0];
        }

        if (Pos[1] == 0 && Pos[0] != 0){
            Pos[1] = EnemyPos[1];
        }
        else if (Pos[1] > 1){
            Pos[1] = EnemyPos[1] - 1;
        }
        else if (Pos[1] < -1){
            Pos[1] = EnemyPos[1] + 1;
        }
        else{
            Pos[1] = EnemyPos[1];
        }

        return Pos;
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


    public boolean captureCheck(int []Player, int []Enemy){
        if (Player[0] == Enemy[0] && Player[1] == Enemy[1]){
            return false;
        }
        else{
            return true;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public int[] respawn(boolean isAlive, int[] EnemyPos, int[] Pos){
        int[] RespawnPos = new int[2];
        int respawn;
        if (isAlive == false){
            respawn = ThreadLocalRandom.current().nextInt(1, 4 + 1);

            if (respawn == 1){
                RespawnPos[0] = 0;
                RespawnPos[1] = 0;
            }
            else if (respawn == 2){
                RespawnPos[0] = 0;
                RespawnPos[1] = 4;
            }
            else if (respawn == 3){
                RespawnPos[0] = 4;
                RespawnPos[1] = 0;
            }
            else if (respawn == 4){
                RespawnPos[0] = 4;
                RespawnPos[1] = 4;
            }

            if (RespawnPos[0] == Pos[0] && RespawnPos[1] == Pos[1]){
                RespawnPos[0] = 2;
                RespawnPos[1] = 2;
            }
            return RespawnPos;
        }
        else{
            RespawnPos[0] = EnemyPos[0];
            RespawnPos[1] = EnemyPos[1];
            return RespawnPos;
        }
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

    public boolean canEnemyMove(int [] PlayerPos, int [] EnemyPos){
        int x = abs(PlayerPos[0] - EnemyPos[0]);
        int y = abs(PlayerPos[1] - EnemyPos[1]);

        if (x + y == 1){
            return true;
        }
        else if (x == 1 && y == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public int Pos_to_id(int []Pos){
        int tile;
        if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))) {
           tile = R.drawable.darktile;
        } else {
           tile = R.drawable.tile;
        }
        return tile;
    }

    public int[] energySymbol(int numMoves){
        int [] energySym = new int[3];

        if (numMoves == 3){
            energySym[0] = R.drawable.energy;
            energySym[1] = R.drawable.energy;
            energySym[2] = R.drawable.energy;
        }
        else if (numMoves == 2){
            energySym[0] = R.drawable.white;
            energySym[1] = R.drawable.energy;
            energySym[2] = R.drawable.energy;
        }
        else if (numMoves == 1){
            energySym[0] = R.drawable.white;
            energySym[1] = R.drawable.white;
            energySym[2] = R.drawable.energy;
        }
        else{
            energySym[0] = R.drawable.white;
            energySym[1] = R.drawable.white;
            energySym[2] = R.drawable.white;
        }
        return energySym;
    }
}
