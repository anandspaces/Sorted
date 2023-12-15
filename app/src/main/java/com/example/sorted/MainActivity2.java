package com.example.sorted;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.editTextText);
        Button back = findViewById(R.id.button6);
        Button findURL = findViewById(R.id.button5);
        back.setOnClickListener(view -> goBack());
        findURL.setOnClickListener(view -> openURL());
    }
    private void goBack(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
    private void openURL(){
        String str = editText.getText().toString();
        if(isValidURL(str)){
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
            startActivity(i);
        } else {
            Toast.makeText(this, "Invalid URL!", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isValidURL(String str){
        return !TextUtils.isEmpty(str) && Patterns.WEB_URL.matcher(str).matches();
    }
}