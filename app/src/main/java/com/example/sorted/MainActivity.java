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

        Button urlFinder = findViewById(R.id.button);
        Button emailSender = findViewById(R.id.button2);
        Button todoMaker = findViewById(R.id.button3);
        Button calculator = findViewById(R.id.button32);
        Button exitButton = findViewById(R.id.button4);
        urlFinder.setOnClickListener(view -> urlFinderFunc());
        emailSender.setOnClickListener(view -> emailSenderFunc());
        todoMaker.setOnClickListener(view -> todoMakerFunc());
        calculator.setOnClickListener(view -> calculatorFunc());
        exitButton.setOnClickListener(view -> exitButtonFunc());
    }
    private void urlFinderFunc(){
        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(i);
    }
    private void emailSenderFunc(){
        Intent i1 = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(i1);
    }
    private void todoMakerFunc(){
        Intent i2 = new Intent(getApplicationContext(), MainActivity4.class);
        startActivity(i2);
    }
    private void calculatorFunc(){
        Intent i3 = new Intent(getApplicationContext(), MainActivity5.class);
        startActivity(i3);
    }
    private void exitButtonFunc(){
        finishAffinity();
        System.exit(0);
    }
}