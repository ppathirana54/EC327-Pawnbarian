/**
 * Creates an object of the Piece Cards, contains the type.
 * 
 * Need to implement a method to return potential moves
 *
 */


import java.util.Hashtable;
//import java.util.ArrayList;


public class Cards
{
    private Hashtable<Integer, String> piecesList = new Hashtable<Integer, String>();
    private int piece;
    // private ArrayList<String> mods?

    public Cards(int piece)
    {
       piecesList.put(1, "Pawn");
       piecesList.put(2, "Knight");
       piecesList.put(3, "Bishop");
       piecesList.put(4, "Rook");
       piecesList.put(5, "Queen");
       piecesList.put(6, "King");

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

    public int[][] getMovement(int[] initPOS)
    {
        //Pawn
        if(piece == 1)
        {
            return {1,0};
        }

        //Knight

        //Bishop

        //Rook

        //Queen

        //King

    }



}