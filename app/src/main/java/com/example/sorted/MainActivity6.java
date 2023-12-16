package com.example.sorted;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {
    private EditText enterResult, enterMin, enterMax;
    private TextView showResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        enterResult = findViewById(R.id.editTextText7);
        showResult = findViewById(R.id.textView7);
        enterMin = findViewById(R.id.editTextNumber);
        enterMax = findViewById(R.id.editTextNumber2);

        // confirm button
        Button confirm = findViewById(R.id.button35);
        confirm.setOnClickListener(view -> gameLogic());
    }
    private int randomFun(int min, int max){
        // To get a random value within a specific range, you can scale and shift the result
        return ((int) (Math.random() * (max - min + 1)) + min);
    }
    private void gameLogic(){
        int min = enterMin.getText().toString().isEmpty() ? 0 : Integer.parseInt(enterMin.getText().toString());
        int max = enterMax.getText().toString().isEmpty() ? 100 : Integer.parseInt(enterMax.getText().toString());
        int num = randomFun(min, max);
        String won = "WON!";
        String now = "Ans: " + num + "\nTry Again!";
        int userInput = enterResult.getText().toString().isEmpty() ? -1 : Integer.parseInt(enterResult.getText().toString());
        if (num==userInput) {
            showResult.setText(won);
        } else {
            showResult.setText(now);
        }
    }
}