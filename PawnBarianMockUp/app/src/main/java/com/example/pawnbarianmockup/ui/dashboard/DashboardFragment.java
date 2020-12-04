package com.example.pawnbarianmockup.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pawnbarianmockup.R;
import com.example.pawnbarianmockup.game.Cards;

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

    private int card1 = 0,
            card2 = 0,
            card3 = 0,
            card;

    private int cardpress1,
            cardpress2,
            cardpress3;

    private int Pos[] = {2, 2};
    private int PastPos[];

    private int tileset;

    boolean turn = true;


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
    public void onActivityCreated(Bundle savedInstanceState) { //Creating image buttons and mapping them
        super.onActivityCreated(savedInstanceState);
        Buttona0 = (ImageButton) getActivity().findViewById(R.id.imageButtona0);
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

        Buttona0.setOnClickListener(this);
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

        Buttonc2.setImageResource(R.drawable.barbarian);

        int     bishop = R.drawable.bishop,
                king = R.drawable.king,
                knight = R.drawable.knight,
                pawn = R.drawable.pawn,
                queen = R.drawable.queen,
                rook = R.drawable.rook;

        Card1.setOnClickListener(this);
        Card2.setOnClickListener(this);
        Card3.setOnClickListener(this);

        //Randomly assign new cards at the start of new turn
        Card1.setImageResource(knight); //For now just change the name for the picture
        Card2.setImageResource(pawn);
        Card3.setImageResource(rook);

        card1 = 2; //For now just change the number based on the number assigned in the Cards class
        card2 = 1;
        card3 = 4;

    }

    public void onClick(View v){
        //Buttona0.setImageResource(R.drawable.barbarian);

        Cards cards = new Cards(1); //get access to Card class functions

        switch(v.getId()){
            case R.id.endturn:{
                turn = !turn;
            }
        }

        //Selector for the move card
        switch(v.getId()){
            case R.id.imageButton:{
                if (turn){
                    cardpress1 = 1;
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                else{
                    cardpress1 = 0;
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                break;
            }
            case R.id.imageButton2:{
                if (turn){
                    cardpress1 = 0;
                    cardpress2 = 1;
                    cardpress3 = 0;
                }
                else{
                    cardpress1 = 0;
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                break;
            }
            case R.id.imageButton3:{
                if (turn){
                    cardpress1 = 0;
                    cardpress2 = 0;
                    cardpress3 = 1;
                }
                else{
                    cardpress1 = 0;
                    cardpress2 = 0;
                    cardpress3 = 0;
                }
                break;
            }
        }

        //Button for each tile and moving the player
        switch(v.getId()){
            case R.id.imageButtona0: {
                int FinalPos1[] = {0, 4}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos1, card); //Checking if movement is valid
                if (move) {
                    Buttona0.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
                    ImageButton button = (ImageButton) requireActivity().findViewById(getResources().getIdentifier("imageButton" + y + Pos[0], "id", this.requireActivity().getPackageName()));
                    button.setImageResource(tileset);
                    Pos = FinalPos1; //Updating position
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
            case R.id.imageButtona1:
            {
                int FinalPos2[] = {1, 4}; //Coordinates of tile
                if (cardpress1 == 1){
                    card = card1;
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos2, card); //Checking if movement is valid
                if (move) {
                    Buttona1.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos3, card); //Checking if movement is valid
                if (move) {
                    Buttona2.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos4, card); //Checking if movement is valid
                if (move) {
                    Buttona3.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos5, card); //Checking if movement is valid
                if (move) {
                    Buttona4.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos6, card); //Checking if movement is valid
                if (move) {
                    Buttonb0.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos7, card); //Checking if movement is valid
                if (move) {
                    Buttonb1.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos8, card); //Checking if movement is valid
                if (move) {
                    Buttonb2.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos9, card); //Checking if movement is valid
                if (move) {
                    Buttonb3.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos10, card); //Checking if movement is valid
                if (move) {
                    Buttonb4.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos11, card); //Checking if movement is valid
                if (move) {
                    Buttonc0.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos12, card); //Checking if movement is valid
                if (move) {
                    Buttonc1.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos13, card); //Checking if movement is valid
                if (move) {
                    Buttonc2.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos14, card); //Checking if movement is valid
                if (move) {
                    Buttonc3.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos15, card); //Checking if movement is valid
                if (move) {
                    Buttonc4.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos16, card); //Checking if movement is valid
                if (move) {
                    Buttond0.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos17, card); //Checking if movement is valid
                if (move) {
                    Buttond1.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos18, card); //Checking if movement is valid
                if (move) {
                    Buttond2.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos19, card); //Checking if movement is valid
                if (move) {
                    Buttond3.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos20, card); //Checking if movement is valid
                if (move) {
                    Buttond4.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos21, card); //Checking if movement is valid
                if (move) {
                    Buttone0.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos22, card); //Checking if movement is valid
                if (move) {
                    Buttone1.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos23, card); //Checking if movement is valid
                if (move) {
                    Buttone2.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos24, card); //Checking if movement is valid
                if (move) {
                    Buttone3.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
                }
                else if (cardpress2 == 1){
                    card = card2;
                }
                else if (cardpress3 == 1){
                    card = card3;
                }
                else{
                    card = 0;
                }
                boolean move = cards.getMovement(Pos, FinalPos25, card); //Checking if movement is valid
                if (move) {
                    Buttone4.setImageResource(R.drawable.barbarian); //Place player after tile reset
                    char y;
                    if (Pos[1] == 0){
                        y = 'e';
                    }
                    else if (Pos[1] == 1){
                        y = 'd';
                    }
                    else if (Pos[1] == 2){
                        y = 'c';
                    }
                    else if (Pos[1] == 3){
                        y = 'b';
                    }
                    else{
                        y = 'a';
                    }
                    if (((Pos[1] == 0 || Pos[1] == 2 || Pos[1] == 4) && (Pos[0] == 0 || Pos[0] == 2 || Pos[0] == 4)) || ((Pos[1] == 1 || Pos[1] == 3) && (Pos[0] == 1 || Pos[0] == 3))){
                        tileset = R.drawable.darktile;
                    }
                    else{
                        tileset = R.drawable.tile;
                    }
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
