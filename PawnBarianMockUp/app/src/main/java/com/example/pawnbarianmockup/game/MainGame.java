package game;

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

    //Find the next position of the enemy by taking the difference between itself and the player
    //If it is more than 1 space away in any direction, it will move one space toward the player
    //If it is right next to the player, it will stay in that spot
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

    //Checks if an enemy is alive
    //If no enemies are alive, this function will create a new one
    //New enemy will appear in any of the four corners
    //If the player is in the spot that the enemy is trying to spawn,
    //It will instead spawn in the center
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

    //Checks if the enemy can move to a space
    //Based on its position and the player's position
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

    //Converts the position into its respective drawable resource
    public int Pos_to_id(int []Pos){
        int tile;
        if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))) {
           tile = R.drawable.darktile;
        } else {
           tile = R.drawable.tile;
        }
        return tile;
    }

    //Sets the drawable resource for energy based on the number of moves
    //The player has left
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
