package com.example.sorted;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // game tab
        Button game = findViewById(R.id.button34);
        game.setOnClickListener(view -> gameFun());

        // url finder tab
        Button urlFinder = findViewById(R.id.button);
        urlFinder.setOnClickListener(view -> urlFinderFun());

        // email sender tab
        Button emailSender = findViewById(R.id.button2);
        emailSender.setOnClickListener(view -> emailSenderFun());

        // to-do maker tab
        Button todoMaker = findViewById(R.id.button3);
        todoMaker.setOnClickListener(view -> todoMakerFun());

        // calculator tab
        Button calculator = findViewById(R.id.button32);
        calculator.setOnClickListener(view -> calculatorFun());

        // exit
        Button exitButton = findViewById(R.id.button4);
        exitButton.setOnClickListener(view -> exitButtonFun());
    }
    private void gameFun(){
        Intent i = new Intent(getApplicationContext(), MainActivity6.class);
        startActivity(i);
    }
    private void urlFinderFun(){
        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(i);
    }
    private void emailSenderFun(){
        Intent i1 = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(i1);
    }
    private void todoMakerFun(){
        Intent i2 = new Intent(getApplicationContext(), MainActivity4.class);
        startActivity(i2);
    }
    private void calculatorFun(){
        Intent i3 = new Intent(getApplicationContext(), MainActivity5.class);
        startActivity(i3);
    }
    private void exitButtonFun(){
        finishAffinity();
        System.exit(0);
    }
}