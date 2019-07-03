package com.example.a02072019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button Rock;
    Button Paper;
    Button Scissors;
    ImageView imageView;
    ImageView imageView2;
    TextView scores;
    TextView UserChoice;
    TextView ComputerChoice;
    int Systemscore,Humanscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rock = (Button)findViewById(R.id.rock);
        Paper = (Button)findViewById(R.id.paper);
        Scissors = (Button)findViewById(R.id.scissors);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        scores = (TextView)findViewById(R.id.scores);
        UserChoice = (TextView)findViewById(R.id.userchoice);
        ComputerChoice = (TextView)findViewById(R.id.computerchoice);


        Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });
        Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            }


        });
        Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.scissors);
            String message = play_turn("scissors");
            Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
        }

        });


    }
    public void play_turn(String player_choice){
        String computer_choice = "";
        Random r = new Random();
        int computer_choice_number = r.nextInt(3)+1;
        if (computer_choice_number==1){
            computer_choice= "Rock";
        }else
        if (computer_choice_number==2) {
            computer_choice = "Paper";
        }else
        if (computer_choice_number==3) {
            computer_choice ="Scissors" ;
        }


        if (computer_choice == "Rock"){
            imageView2.setImageResource(R.drawable.rock);
        }else
        if (computer_choice == "Paper"){
            imageView2.setImageResource(R.drawable.paper);
        }else
        if (computer_choice == "Scissors"){
            imageView2.setImageResource(R.drawable.scissors);
        }

        if(computer_choice == player_choice){
            return "Draw";
        }else
            if(computer_choice == "rock" && player_choice == "scissors")
            {
                Systemscore++;
                return "Rock crushes scissors,System wins";
            }
            else
            if(computer_choice == "scissors" && player_choice == "paper")
            {
                Systemscore++;
                return "scissors cut paper,System wins";
            }
            else
            if(computer_choice == "paper" && player_choice == "rock")
            {
                Systemscore++;
                return "Paper covers rock,System wins";
            }
            else
            if(player_choice == "paper" && computer_choice == "rock")
            {
                Humanscore++;
                return "Paper covers rock,You win";
            }else

            if(player_choice == "scissors" && computer_choice== "paper")
            {
                Humanscore++;
                return "scissors cuts paper ,You win";
            }
            else
            if(player_choice=="rock"&& computer_choice=="scissora")
            {
                Humanscore++;
                return "Rock crushes scissors,You win";
            }
            else
                return "Not clear";


    }


}
