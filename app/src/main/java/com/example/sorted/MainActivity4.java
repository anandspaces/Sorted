package com.example.sorted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    EditText note;
    TextView archiveNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        note = findViewById(R.id.editTextText5);
        archiveNote = findViewById(R.id.textView5);
        Button back = findViewById(R.id.button9);
        Button addB = findViewById(R.id.button10);
        Button editB = findViewById(R.id.button12);
        Button deleteB = findViewById(R.id.button11);
        back.setOnClickListener(view -> backFunc());
        addB.setOnClickListener(view -> addFunc());
        editB.setOnClickListener(view -> editFunc());
        deleteB.setOnClickListener(view -> deleteFunc());
    }
    private void backFunc(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
    private void addFunc(){
        String str = note.getText().toString();
        archiveNote.setText(str);
    }
    private void editFunc(){
        String str = archiveNote.getText().toString();
        note.setText(str);
    }
    private void deleteFunc(){
        String str = "";
        archiveNote.setText(str);
    }
}