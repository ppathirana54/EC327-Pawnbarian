/**
 * Just a test class used to test objects and constructors
 *
 * 
 */



public class Test{
    public static void main(String[]args)
    {
        // Char test = new Char();
        
        // System.out.println(test.getName());
        
        // Player joe = new Player();
        
        // //cout << = System.out.print()
        // //cout << endln; == System.out.println()
        // System.out.println(joe.getName());
        // System.out.println(joe.getHealth());
        // System.out.println(joe.getWealth());
        
        // joe.heal();
        
        // System.out.println(joe.getHealth());
        
        // Board testboard = new Board();
        // System.out.println(testboard.getplayerposition()[0] + " " + testboard.getplayerposition()[1]);     
        // System.out.println(tesboard.getNumberenemies());

        // Cards pawn = new Cards(1);
        // System.out.println(pawn.getPiece());


        //11/25/20
        /*Cards test = new Cards(3);

        System.out.println(test.getPiece());

        int initPOS[] = {0,0};
        int finalPOS[] = {0,3}; 
        System.out.println(test.getMovement(initPOS, finalPOS));
        */
        
        // 11/26/20 enemy class test
        Enemy testenemy = new Enemy();
        System.out.println(testenemy.getHealth());
        testenemy.setHealth(2);
        System.out.println(testenemy.getHealth());
        System.out.println(testenemy.getPos()[0] + " " + testenemy.getPos()[1]);
        testenemy.moveTo(3,3);
        System.out.println(testenemy.getPos()[0] + " " + testenemy.getPos()[1]);
    }
}
