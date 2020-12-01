
package com.example.pawnbarianmockup.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pawnbarianmockup.R;

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

    private DashboardViewModel dashboardViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
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

        Buttonc2.setImageResource(R.drawable.barbarian);
    }

    public void onClick(View v){
        //Buttona0.setImageResource(R.drawable.barbarian);
        int tileset;


        switch(v.getId()){
            case R.id.imageButtona0:
            {
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttona0.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtona1:
            {
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttona1.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtona2: {
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttona2.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtona3:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttona3.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtona4:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttona4.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonb0:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonb0.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonb1:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonb1.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonb2:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonb2.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonb3:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonb3.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonb4:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonb4.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonc0:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonc0.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonc1:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonc1.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonc2:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonc2.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonc3:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonc3.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtonc4:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttonc4.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtond0:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttond0.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtond1:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttond1.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtond2:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttond2.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtond3:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttond3.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtond4:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttond4.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtone0:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttone0.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtone1:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttone1.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtone2:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttone2.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtone3:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttone3.setImageResource(R.drawable.barbarian);
                break;
            }
            case R.id.imageButtone4:{
                for (char y = 'a'; y < 'f'; y++){
                    for (int i = 0; i < 5; i++){
                        if (((y == 'a' || y == 'c' || y == 'e') && (i == 0 || i == 2 || i == 4)) || ((y == 'b' || y == 'd') && (i == 1 || i == 3))){
                            tileset = R.drawable.darktile;
                        }
                        else{
                            tileset = R.drawable.tile;
                        }
                        ImageButton button = (ImageButton) getActivity().findViewById(getResources().getIdentifier("imageButton" + y + i, "id", this.getActivity().getPackageName()));

                        button.setImageResource(tileset);
                    }
                }
                Buttone4.setImageResource(R.drawable.barbarian);
                break;
            }
        }
    }
}
