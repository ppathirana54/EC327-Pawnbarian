package com.example.pawnbarianmockup.ui.dashboard;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import static java.lang.Math.abs;
import java.util.concurrent.ThreadLocalRandom;

import com.example.pawnbarianmockup.R;
import com.example.pawnbarianmockup.game.Cards;
import com.example.pawnbarianmockup.game.Board;
import com.example.pawnbarianmockup.game.Char;
import com.example.pawnbarianmockup.game.Enemy;
import com.example.pawnbarianmockup.game.MainGame;
import com.example.pawnbarianmockup.game.Player;

import android.content.Intent;
import com.example.pawnbarianmockup.GameOverActivity;

import java.util.Hashtable;


public class DashboardFragment extends Fragment implements View.OnClickListener{

    private ImageButton Buttona0;
    private ImageButton Buttona1;
    private ImageButton Buttona2;
    private ImageButton Buttona3;
    private ImageButton Buttona4;
    private ImageButton Buttonb0;
    private ImageButton Buttonb1;
    private ImageButton Buttonb2;
    private ImageButton Buttonb3;
    private ImageButton Buttonb4;
    private ImageButton Buttonc0;
    private ImageButton Buttonc1;
    private ImageButton Buttonc2;
    private ImageButton Buttonc3;
    private ImageButton Buttonc4;
    private ImageButton Buttond0;
    private ImageButton Buttond1;
    private ImageButton Buttond2;
    private ImageButton Buttond3;
    private ImageButton Buttond4;
    private ImageButton Buttone0;
    private ImageButton Buttone1;
    private ImageButton Buttone2;
    private ImageButton Buttone3;
    private ImageButton Buttone4;

    private ImageButton Card1;
    private ImageButton Card2;
    private ImageButton Card3;

    private Button EndTurn;

    private ImageView Heart0;
    private ImageView Heart1;
    private ImageView Heart2;

    private ImageView Energy0;
    private ImageView Energy1;
    private ImageView Energy2;

    private int card1 = 0, //Variable for each piece card
                card2 = 0,
                card3 = 0,
                card;

    private int cardpress1, //Variable to see if card selector is pressed
                cardpress2,
                cardpress3,
                cardactive1,
                cardactive2,
                cardactive3;

    private int Pos[] = {2, 1}; //Player position

    private int tileset; //Variable for tile id

    boolean turn = true; //Variable for player turn

    int numMoves = 2; //Number of moves per turn, dictates amount of energy

    int enemies_defeated=0; // counter for number of enemies defeated

    int Energy[]; //Variable for energy

    int EnemyPos[] = {2, 4}; //Enemy position
    int [] NewEnemyPos;

    MainGame game = new MainGame(); //Access to MainGame class

    private int health = 3; //Health of player

    boolean EnemyMove = true; //Variable for enemy movement

    boolean EnemyAlive1 = true; //Variable for enemy existence

    boolean gameOver = false; //Game over?

    int progression = 0;


    private Hashtable<Integer, Character> int_to_char = new Hashtable<Integer, Character>(); //Hashtable for temp button calls

    private Hashtable<Integer, Integer> int_to_id = new Hashtable<Integer, Integer>(); //Hashtable for drawable id calls

    private DashboardViewModel dashboardViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) { //Set up the board state for the game to begin
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Buttona0 = (ImageButton) getActivity().findViewById(R.id.imageButtona0); //Creating image buttons and mapping them
        Buttona1 = (ImageButton) getActivity().findViewById(R.id.imageButtona1);
        Buttona2 = (ImageButton) getActivity().findViewById(R.id.imageButtona2);
        Buttona3 = (ImageButton) getActivity().findViewById(R.id.imageButtona3);
        Buttona4 = (ImageButton) getActivity().findViewById(R.id.imageButtona4);

        Buttonb0 = (ImageButton) getActivity().findViewById(R.id.imageButtonb0);
        Buttonb1 = (ImageButton) getActivity().findViewById(R.id.imageButtonb1);
        Buttonb2 = (ImageButton) getActivity().findViewById(R.id.imageButtonb2);
        Buttonb3 = (ImageButton) getActivity().findViewById(R.id.imageButtonb3);
        Buttonb4 = (ImageButton) getActivity().findViewById(R.id.imageButtonb4);

        Buttonc0 = (ImageButton) getActivity().findViewById(R.id.imageButtonc0);
        Buttonc1 = (ImageButton) getActivity().findViewById(R.id.imageButtonc1);
        Buttonc2 = (ImageButton) getActivity().findViewById(R.id.imageButtonc2);
        Buttonc3 = (ImageButton) getActivity().findViewById(R.id.imageButtonc3);
        Buttonc4 = (ImageButton) getActivity().findViewById(R.id.imageButtonc4);

        Buttond0 = (ImageButton) getActivity().findViewById(R.id.imageButtond0);
        Buttond1 = (ImageButton) getActivity().findViewById(R.id.imageButtond1);
        Buttond2 = (ImageButton) getActivity().findViewById(R.id.imageButtond2);
        Buttond3 = (ImageButton) getActivity().findViewById(R.id.imageButtond3);
        Buttond4 = (ImageButton) getActivity().findViewById(R.id.imageButtond4);

        Buttone0 = (ImageButton) getActivity().findViewById(R.id.imageButtone0);
        Buttone1 = (ImageButton) getActivity().findViewById(R.id.imageButtone1);
        Buttone2 = (ImageButton) getActivity().findViewById(R.id.imageButtone2);
        Buttone3 = (ImageButton) getActivity().findViewById(R.id.imageButtone3);
        Buttone4 = (ImageButton) getActivity().findViewById(R.id.imageButtone4);

        Card1 = (ImageButton) getActivity().findViewById(R.id.imageButton);
        Card2 = (ImageButton) getActivity().findViewById(R.id.imageButton2);
        Card3 = (ImageButton) getActivity().findViewById(R.id.imageButton3);

        EndTurn = (Button) getActivity().findViewById(R.id.endturn);

        Heart0 = (ImageView) getActivity().findViewById(R.id.heart0); //Setting images for health and energy
        Heart1 = (ImageView) getActivity().findViewById(R.id.heart1);
        Heart2 = (ImageView) getActivity().findViewById(R.id.heart2);

        Energy0 = (ImageView) getActivity().findViewById(R.id.energy0);
        Energy1 = (ImageView) getActivity().findViewById(R.id.energy1);
        Energy2 = (ImageView) getActivity().findViewById(R.id.energy2);

        Buttona0.setOnClickListener(this); //OnClicker for buttons
        Buttona1.setOnClickListener(this);
        Buttona2.setOnClickListener(this);
        Buttona3.setOnClickListener(this);
        Buttona4.setOnClickListener(this);

        Buttonb0.setOnClickListener(this);
        Buttonb1.setOnClickListener(this);
        Buttonb2.setOnClickListener(this);
        Buttonb3.setOnClickListener(this);
        Buttonb4.setOnClickListener(this);

        Buttonc0.setOnClickListener(this);
        Buttonc1.setOnClickListener(this);
        Buttonc2.setOnClickListener(this);
        Buttonc3.setOnClickListener(this);
        Buttonc4.setOnClickListener(this);

        Buttond0.setOnClickListener(this);
        Buttond1.setOnClickListener(this);
        Buttond2.setOnClickListener(this);
        Buttond3.setOnClickListener(this);
        Buttond4.setOnClickListener(this);

        Buttone0.setOnClickListener(this);
        Buttone1.setOnClickListener(this);
        Buttone2.setOnClickListener(this);
        Buttone3.setOnClickListener(this);
        Buttone4.setOnClickListener(this);

        EndTurn.setOnClickListener(this);

        Buttond2.setImageResource(R.drawable.pixelknight); //Setting initial player position

        int     bishop = R.drawable.bishop, //Id for pieces
                king = R.drawable.king,
                knight = R.drawable.knight,
                pawn = R.drawable.pawn,
                queen = R.drawable.queen,
                rook = R.drawable.rook,
                slime = R.drawable.slime;

        Card1.setOnClickListener(this); //Setting card selector buttons
        Card2.setOnClickListener(this);
        Card3.setOnClickListener(this);


        Card1.setImageResource(knight); //Initial piece cards
        Card2.setImageResource(pawn);
        Card3.setImageResource(king);

        card1 = 2; //Piece id for getMovement function
        card2 = 1;
        card3 = 6;

        int_to_char.put(0, 'e'); //Loading hashtable
        int_to_char.put(1, 'd');
        int_to_char.put(2, 'c');
        int_to_char.put(3, 'b');
        int_to_char.put(4, 'a');

        int_to_id.put(1, R.drawable.pawn); //Loading hashtable
        int_to_id.put(2, R.drawable.knight);
        int_to_id.put(3, R.drawable.bishop);
        int_to_id.put(4, R.drawable.rook);
        int_to_id.put(5, R.drawable.queen);
        int_to_id.put(6, R.drawable.king);
        int_to_id.put(7, R.drawable.blank);
        int_to_id.put(8, R.drawable.blank);
        int_to_id.put(9, R.drawable.blank);
        int_to_id.put(10, R.drawable.blank);
        int_to_id.put(11, R.drawable.blank);
        int_to_id.put(12, R.drawable.blank);
        int_to_id.put(13, R.drawable.blank);
        int_to_id.put(14, R.drawable.blank);
        int_to_id.put(15, R.drawable.blank);
        int_to_id.put(16, R.drawable.blank);
        int_to_id.put(17, R.drawable.blank);
        int_to_id.put(18, R.drawable.blank);

        Toast.makeText(this.getActivity(), "Instructions:", Toast.LENGTH_LONG).show();
        Toast.makeText(this.getActivity(), "Click on a card to move the knight like that piece.", Toast.LENGTH_LONG).show();
        Toast.makeText(this.getActivity(), "Then click a square to move to it.", Toast.LENGTH_LONG).show();
        Toast.makeText(this.getActivity(), "The energy shows you how many moves you have left this turn and hearts how many lives you have left.", Toast.LENGTH_LONG).show();
        Toast.makeText(this.getActivity(), "When you finish your turn, click End Your Turn to let the slime move or respawn.", Toast.LENGTH_LONG).show();
        Toast.makeText(this.getActivity(), "Then click Start Your turn to take your next move.", Toast.LENGTH_LONG).show();
        Toast.makeText(this.getActivity(), "If you end your turn next to the slime you will lose a life.", Toast.LENGTH_LONG).show();
        Toast.makeText(this.getActivity(), "Good luck!", Toast.LENGTH_LONG).show();
        //Spawning Enemies in initial positions
        ImageButton button1 = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + 'a' + 2, "id", this.requireActivity().getPackageName()));
        button1.setImageResource(slime);
        //ImageButton button2 = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + 'b' + 0, "id", this.requireActivity().getPackageName()));
        //button2.setImageResource(slime);
        //ImageButton button3 = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + 'b' + 4, "id", this.requireActivity().getPackageName()));
        //button3.setImageResource(slime);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View v){
        Cards cards = new Cards(1); //Get access to Card class functions

        int slime = R.drawable.slime; //Set id for enemy drawable
        int tile; //Variable for tile drawable

        //End Turn
        switch(v.getId()){ //End turn Button
            //End of turn actions, Enemy move, Damage calculation
            case R.id.endturn:{
                if (gameOver == false){

                    turn = !turn; //Check if it is the Player's turn
                    if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1]) { //Check if enemy is alive
                        EnemyAlive1 = false;
                        enemies_defeated +=1;  //increment counter for number of enemies killed
                        TextView text = getActivity().findViewById(R.id.text_dashboard);
                        text.setText("Kill Counter:"+enemies_defeated/2); //Change text on button
                        progression += 1;   //makes game harder every time a slime is captured
                    }
                    if (turn == false) { //If not player's turn...
                        numMoves = 2; //Reset number of moves to max
                        EndTurn.setText(R.string.Your_Turn); //Change text on button
                        if (EnemyAlive1 == true) { //If enemy is alive...
                            NewEnemyPos = game.enemyTurn(EnemyPos, Pos); //Find next position of Enemy
                            char t, p;
                            t = int_to_char.get(NewEnemyPos[1]);
                            p = int_to_char.get(EnemyPos[1]);
                            EnemyMove = game.canEnemyMove(Pos, EnemyPos); //Check if enemy can move

                            if (EnemyMove == false && EnemyAlive1 == true) { //If enemy CAN move, then...
                                ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + t + NewEnemyPos[0], "id", this.requireActivity().getPackageName()));
                                button.setImageResource(slime); //"Move" enemy closer to player
                                tile = game.Pos_to_id(EnemyPos);
                                ImageButton button1 = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + p + EnemyPos[0], "id", this.requireActivity().getPackageName()));
                                button1.setImageResource(tile); //Set previous space to tile drawable
                                EnemyPos = NewEnemyPos; //Update enemy position after movement
                            } else { //If enemy is cannot move (ie. enemy is right next to player)
                                health = health - 1; //Player loses 1 health
                            }
                        }
                        if (health == 2) { //Setting image drawable based on player health
                            Heart0.setImageResource(R.drawable.emptyheart);
                        } else if (health == 1) {
                            Heart0.setImageResource(R.drawable.emptyheart);
                            Heart1.setImageResource(R.drawable.emptyheart);
                        } else if (health == 0) {
                            Heart0.setImageResource(R.drawable.emptyheart);
                            Heart1.setImageResource(R.drawable.emptyheart);
                            Heart2.setImageResource(R.drawable.emptyheart);

                            gameOver = true;
                            Toast.makeText(this.getActivity(), "Good Job! You defeated " + enemies_defeated/2 +" slimes", Toast.LENGTH_LONG).show();
                            Toast.makeText(this.getActivity(), "Maybe if you tried harder you wouldn't lose!\n\n-Blob the slime", Toast.LENGTH_LONG).show();

                            Intent gameOverIntent = new Intent(getActivity(), GameOverActivity.class);
                            gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            getActivity().startActivity(gameOverIntent);

                        }
                    } else {
                        EndTurn.setText(R.string.Enemy_Turn); //If it's player's turn...

                        EnemyPos = game.respawn(EnemyAlive1, EnemyPos, Pos); //Check if enemy can respawn

                        if (EnemyAlive1 == false) { //If enemy is dead...
                            EnemyAlive1 = true; //Set enemy existence variable to true...
                            char q = int_to_char.get(EnemyPos[1]);
                            ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + q + EnemyPos[0], "id", this.requireActivity().getPackageName()));
                            button.setImageResource(slime); //Set enemy in respawn location
                        }

                        int nextCard1 = cards.newCard(progression); //Set piece cards to new pieces
                        int nextCard2 = cards.newCard(progression);
                        int nextCard3 = cards.newCard(progression);

                        card1 = nextCard1; //Update piece card variables for getMovement function
                        card2 = nextCard2;
                        card3 = nextCard3;

                        Card1.setImageResource(int_to_id.get(nextCard1)); //Set piece card drawable
                        Card2.setImageResource(int_to_id.get(nextCard2));
                        Card3.setImageResource(int_to_id.get(nextCard3));

                        Energy0.setImageResource(R.drawable.white); //Reset energy for start of new turn
                        Energy1.setImageResource(R.drawable.energy);
                        Energy2.setImageResource(R.drawable.energy);
                    }
                }
            }
        }

        //Selector for the move card
        switch(v.getId()){ //Case/switch for buttons press of piece cards
            case R.id.imageButton:{
                if (turn && numMoves > 0 && gameOver == false){ //Check if it's player's turn and still have moves left
                    cardpress1 = 1;
                    cardpress2 = 0;
                    cardpress3 = 0;
                    cardactive1 = 1;
                    cardactive2 = 0;
                    cardactive3 = 0;
                }
                else{
                    if (numMoves<1)
                        Toast.makeText(this.getActivity(), "Out of moves for this turn", Toast.LENGTH_SHORT).show();
                    if (!turn)
                        Toast.makeText(this.getActivity(), "Not your turn currently. \nPress Start Your Turn", Toast.LENGTH_SHORT).show();
                    cardpress1 = 0; //Ensures no movement if conditionals fail
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                break; //Identical functionality for all 3 piece cards
            }
            case R.id.imageButton2:{
                if (turn && numMoves > 0 && gameOver == false){
                    cardpress1 = 0;
                    cardpress2 = 1;
                    cardpress3 = 0;
                    cardactive1 = 0;
                    cardactive2 = 1;
                    cardactive3 = 0;
                }
                else{
                    if (numMoves<1)
                        Toast.makeText(this.getActivity(), "Out of moves for this turn", Toast.LENGTH_SHORT).show();
                    if (!turn)
                        Toast.makeText(this.getActivity(), "Not your turn currently. \nPress Start Your Turn", Toast.LENGTH_SHORT).show();
                    cardpress1 = 0;
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                break;
            }
            case R.id.imageButton3:{
                if (turn && numMoves > 0 && gameOver == false){
                    cardpress1 = 0;
                    cardpress2 = 0;
                    cardpress3 = 1;
                    cardactive1 = 0;
                    cardactive2 = 0;
                    cardactive3 = 1;
                }
                else{
                    if (numMoves<1)
                        Toast.makeText(this.getActivity(), "Out of moves for this turn", Toast.LENGTH_SHORT).show();
                    if (!turn)
                        Toast.makeText(this.getActivity(), "Not your turn currently. \nPress Start Your Turn", Toast.LENGTH_SHORT).show();
                    cardpress1 = 0;
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                break;
            }
        }

        //Button for each tile and moving the player
        switch(v.getId()){ //Switch/case for each space on 5 x 5 board
            case R.id.imageButtona0: {
                int FinalPos1[] = {0, 4}; //Coordinates of tile
                if (cardpress1 == 1){ //Check which piece card is pressed
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                    
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos1, card); //Checking if movement is valid
                if (move) { //If movement is valid...
                    numMoves -= 1; //Lose one energy
                    Energy = game.energySymbol(numMoves); //Update amount of energy and set drawables
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttona0.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset); //Set previous location to tile
                    Pos = FinalPos1; //Updating position
                    cardpress1 = 0; //Resetting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {//Invalid move message
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Resetting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break; //Similar functionality for rest of tiles
            }
            case R.id.imageButtona1:
            {
                int FinalPos2[] = {1, 4}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos2, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttona1.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos2; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtona2: {
                int FinalPos3[] = {2, 4}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos3, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttona2.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos3; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtona3:{
                int FinalPos4[] = {3, 4}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos4, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttona3.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos4; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtona4:{
                int FinalPos5[] = {4, 4}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos5, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttona4.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos5; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonb0:{
                int FinalPos6[] = {0, 3}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos6, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonb0.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos6; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonb1:{
                int FinalPos7[] = {1, 3}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos7, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonb1.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos7; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonb2:{
                int FinalPos8[] = {2, 3}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos8, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonb2.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos8; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonb3:{
                int FinalPos9[] = {3, 3}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos9, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonb3.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos9;
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonb4:{
                int FinalPos10[] = {4, 3}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos10, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonb4.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos10; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonc0:{
                int FinalPos11[] = {0, 2}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos11, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonc0.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos11; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonc1:{
                int FinalPos12[] = {1, 2}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos12, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonc1.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos12;
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonc2:{
                int FinalPos13[] = {2, 2}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos13, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonc2.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos13; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonc3:{
                int FinalPos14[] = {3, 2}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos14, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonc3.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos14; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtonc4:{
                int FinalPos15[] = {4, 2}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos15, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttonc4.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos15; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtond0:{
                int FinalPos16[] = {0, 1}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos16, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttond0.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos16; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtond1:{
                int FinalPos17[] = {1, 1}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos17, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttond1.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos17; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtond2:{
                int FinalPos18[] = {2, 1}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos18, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttond2.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos18; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtond3:{
                int FinalPos19[] = {3, 1}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos19, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttond3.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos19; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtond4:{
                int FinalPos20[] = {4, 1}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos20, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttond4.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos20; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtone0:{
                int FinalPos21[] = {0, 0}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos21, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttone0.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos21; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtone1:{
                int FinalPos22[] = {1, 0}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos22, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttone1.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos22; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtone2:{
                int FinalPos23[] = {2, 0}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos23, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttone2.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos23; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtone3:{
                int FinalPos24[] = {3, 0}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos24, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttone3.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos24; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
            case R.id.imageButtone4:{
                int FinalPos25[] = {4, 0}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress2 == 1){
                    card = card2;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else if (cardpress3 == 1){
                    card = card3;
                    if (card==1) 
                    {
                        if ((Pos[0] - EnemyPos[0]) == 1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureleft();
                        else if ((Pos[0] - EnemyPos[0]) == -1 && Pos[1] == EnemyPos[1] - 1)
                            cards.set_pawncancaptureright();
                        else if (Pos[0] == EnemyPos[0] && Pos[1] == EnemyPos[1] - 1)
                            cards.set_enemyinfrontofpawn();
                    }
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos25, card); //Checking if movement is valid
                if (move) {
                    numMoves -= 1;
                    Energy = game.energySymbol(numMoves);
                    Energy0.setImageResource(Energy[0]);
                    Energy1.setImageResource(Energy[1]);
                    Energy2.setImageResource(Energy[2]);
                    Buttone4.setImageResource(R.drawable.pixelknight); //Place player after tile reset
                    char y;
                    y = int_to_char.get(Pos[1]);
                    tileset = game.Pos_to_id(Pos);
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos25; //Updating position
                    cardpress1 = 0; //Reseting selector states
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else
                {
                    Toast.makeText(this.getActivity(), "Invalid Move! \nPick a card", Toast.LENGTH_SHORT).show();
                }

                cardpress1 = 0; //Reseting selector states
                cardpress2 = 0;
                cardpress3 = 0;
                break;
            }
        }
    }
}
