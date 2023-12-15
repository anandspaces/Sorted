package com.example.sorted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private EditText sendTo, subject, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sendTo = findViewById(R.id.editTextText2);
        subject = findViewById(R.id.editTextText3);
        body = findViewById(R.id.editTextText4);
        Button submit = findViewById(R.id.button7);
        Button back = findViewById(R.id.button8);
        submit.setOnClickListener(view -> emailSender());
        back.setOnClickListener(view -> goBack());
    }
    private void goBack(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    private void emailSender(){
        String emailSend = sendTo.getText().toString();
        String emailSubject = subject.getText().toString();
        String emailBody = body.getText().toString();

        if(isValidEmail(emailSend)){
            Intent i = new Intent(Intent.ACTION_SEND);

            i.putExtra(Intent.EXTRA_EMAIL, new String[]{emailSend});
            i.putExtra((Intent.EXTRA_SUBJECT),emailSubject);
            i.putExtra((Intent.EXTRA_TEXT),emailBody);

            i.setType("message/rfc822");
            try{
                startActivity(Intent.createChooser(i,"Send Email with: "));
            } catch (android.content.ActivityNotFoundException e){
                Toast.makeText(this, "No email clients installed!", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Invalid Email Address!", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}