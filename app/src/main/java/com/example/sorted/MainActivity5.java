package com.example.sorted;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    private EditText editText;
    private double firstOperand = Double.NaN;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        editText = findViewById(R.id.editTextText6);

        // Set click listeners for numeric and operator buttons
        setNumericButtonClickListeners();
        setOperatorButtonClickListeners();

        // Set click listeners for special buttons
        setSpecialButtonClickListeners();

        // Handle Back Button
        Button backButton = findViewById(R.id.button31);
        backButton.setOnClickListener(view -> backButtonFunction());

        // Handle equals button
        Button equalsButton = findViewById(R.id.button28);
        equalsButton.setOnClickListener(view -> calculateResult());

        // Handle clear button
        Button clearButton = findViewById(R.id.button30);
        clearButton.setOnClickListener(view -> clearInput());
    }

    // Set click listeners for numeric buttons
    private void setNumericButtonClickListeners() {
        int[] numericButtonIds = {R.id.button20, R.id.button17, R.id.button18, R.id.button19, R.id.button21, R.id.button22, R.id.button23, R.id.button24, R.id.button25, R.id.button26};
        for (int buttonId : numericButtonIds) {
            Button button = findViewById(buttonId);
            button.setOnClickListener(view -> appendToInput(((Button) view).getText().toString()));
        }
    }

    // Set click listeners for operator buttons
    private void setOperatorButtonClickListeners() {
        int[] operatorButtonIds = {R.id.button13, R.id.button15, R.id.button16, R.id.button14, R.id.button29};
        for (int buttonId : operatorButtonIds) {
            Button button = findViewById(buttonId);
            button.setOnClickListener(view -> handleOperator(((Button) view).getText().toString()));
        }
    }

    // Set click listeners for special buttons (decimal and exponential)
    private void setSpecialButtonClickListeners() {
        Button decimalButton = findViewById(R.id.button27);
        decimalButton.setOnClickListener(view -> appendToInput(((Button) view).getText().toString()));

        Button exponentialButton = findViewById(R.id.button33);
        exponentialButton.setOnClickListener(view -> handleOperator(((Button) view).getText().toString()));
    }

    // Set backButton Function
    private void backButtonFunction() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    // Append text to the input field
    private void appendToInput(String text) {
        editText.append(text);
    }

    // Handle operator button click
    private void handleOperator(String newOperator) {
        if (!Double.isNaN(firstOperand)) {
            calculateResult();
        }
        firstOperand = Double.parseDouble(editText.getText().toString());
        operator = newOperator;
        editText.setText("");
    }

    // Calculate and display the result
    private void calculateResult() {
        if (!Double.isNaN(firstOperand) && !editText.getText().toString().isEmpty()) {
            double secondOperand = Double.parseDouble(editText.getText().toString());
            double result = 0.0;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    }
                    break;
                case "%":
                    result = firstOperand % secondOperand;
                    break;
                case "^": // Exponential operator
                    result = Math.pow(firstOperand, secondOperand);
                    break;
            }

            editText.setText(String.valueOf(result));
            firstOperand = result;
        }
    }

    // Clear the input field and reset variables
    private void clearInput() {
        editText.setText("");
        firstOperand = Double.NaN;
        operator = "";
    }
}