/**
 * Creates an object of the Piece Cards, contains the type.
 * 
 * Need to implement a method to return potential moves
 *
 */


import java.util.Hashtable;
import java.lang.Math;
//import java.util.ArrayList;


public class Cards
{
    private Hashtable<Integer, String> piecesList = new Hashtable<Integer, String>();
    private int piece;
    // private ArrayList<String> mods?

    public Cards(int piece)
    {
       piecesList.put(0, "Pawn");
       piecesList.put(1, "Knight");
       piecesList.put(2, "Bishop");
       piecesList.put(3, "Rook");
       piecesList.put(4, "Queen");
       piecesList.put(5, "King");

       this.piece = piece;
    }

    public String getPiece()
    {
        return piecesList.get(piece);
    }

    public void setPeice(int piece)
    {
        this.piece = piece;
    }

    public boolean getMovement(int[] initPOS, int[] finalPOS)
    {
        //Pawn
        if(piece == 0)
        {   
            //Setting the move coordinates for the piece

            //Error checking
            int y = finalPOS[1] - initPOS[1];
            if(y == 1)
            {
              return true;
            }
        }

        //Knight
        else if(piece == 1)
        {
            int x = Math.abs(initPOS[0] - finalPOS[0]); 
            int y = Math.abs(initPOS[1] - finalPOS[1]); 
            return x * y == 2;  
        }

        //Bishop
        else if(piece == 2)
        {
            int x = finalPOS[0] - initPOS[0];
            int y = finalPOS[1] - initPOS[1];

            if (Math.abs(x) == Math.abs(y)){
              return true;
            }
            else{
              return false;
            }
        }

        //Rook
        else if(piece == 3)
        {
            if (initPOS[0] == finalPOS[0] || initPOS[1] == finalPOS[1]){
              return true;
            }
            else{
              return false;
            }
        }

        //Queen
        else if(piece == 4)
        {
            int x = finalPOS[0] - initPOS[0];
            int y = finalPOS[1] - initPOS[1];

            if (initPOS[0] == finalPOS[0] || initPOS[1] == finalPOS[1]){
              return true;
            }
            else if (Math.abs(x) == Math.abs(y)){
              return true;
            }
            else{
              return false;
            }
        }

        //King
        else if(piece == 5)
        {
            int x = finalPOS[0] - initPOS[0];
            int y = finalPOS[1] - initPOS[1];

            if (Math.abs(x + y) == 1){
              return true;
            }
            else if ((Math.abs(x) == 1 && Math.abs(y) == 1)){
              return true;
            }
            else{
              return false;
            }
        }

        return false;

    }



}
