package com.example.pawnbarianmockup.game; /**
/**
 * Creates an object of the Piece Cards, contains the type.
 *
 * Need to implement a method to return potential moves
 *
 */


import java.util.Hashtable;
import static java.lang.Math.abs;
//import java.util.ArrayList;


public class Cards
{
    private Hashtable<Integer, String> piecesList = new Hashtable<Integer, String>();
    private int piece;
    private boolean pawncancapture;
    private boolean enemyinfrontofpawn;
    // private ArrayList<String> mods?

    public Cards(int piece)
    {
        piecesList.put(1, "Pawn");
        piecesList.put(2, "Knight");
        piecesList.put(3, "Bishop");
        piecesList.put(4, "Rook");
        piecesList.put(5, "Queen");
        piecesList.put(6, "King");

        pawncancapture = false;
        enemyinfrontofpawn = false;

        this.piece = piece;
    }
    public void set_pawncancapture()
    {
        pawncancapture = true;
    }

    public void set_enemyinfrontofpawn()
    {
        enemyinfrontofpawn = true;
    }

    public String getPiece()
    {
        return piecesList.get(piece);
    }

    public void setPeice(int piece)
    {
        this.piece = piece;
    }

    public boolean getMovement(int[] initPOS, int[] finalPOS, int piece)
    {
        //Pawn
        if(piece == 1)
        {
            int x = finalPOS[0] - initPOS[0];
            int y = finalPOS[1] - initPOS[1];

            if (!enemyinfrontofpawn && x==0 && y==1)
                return true;
            else if (pawncancapture && abs(x)==1 && y==1)
                return true;
            else
                return false;

        }

        //Knight
        else if(piece == 2)
        {
            int x = finalPOS[0] - initPOS[0];
            int y = finalPOS[1] - initPOS[1];

            if ((abs(x) == 2 && abs(y) == 1) || (abs(y) == 2 && abs(x) == 1)){
                return true;
            }
            else{
                return false;
            }
        }

        //Bishop
        else if(piece == 3)
        {
            int x = finalPOS[0] - initPOS[0];
            int y = finalPOS[1] - initPOS[1];

            if (abs(x) == abs(y)){
                return true;
            }
            else{
                return false;
            }
        }

        //Rook
        else if(piece == 4)
        {
            if (((initPOS[0] == finalPOS[0]) && (initPOS[1] != finalPOS[1])) || ((initPOS[1] == finalPOS[1]) && (initPOS[0] != finalPOS[0]))){
                return true;
            }
            else{
                return false;
            }
        }

        //Queen
        else if(piece == 5)
        {
            int x = finalPOS[0] - initPOS[0];
            int y = finalPOS[1] - initPOS[1];

            if (initPOS[0] == finalPOS[0] || initPOS[1] == finalPOS[1]){
                return true;
            }
            else if (abs(x) == abs(y)){
                return true;
            }
            else{
                return false;
            }
        }

        //King
        else if(piece == 6)
        {
            int x = finalPOS[0] - initPOS[0];
            int y = finalPOS[1] - initPOS[1];

            if ((abs(x) + abs(y)) == 1){
                return true;
            }
            else if ((abs(x) == 1 && abs(y) == 1)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
