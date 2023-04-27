package com.example.sharedpreference;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText username, password;
    Button signup, cancel;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        signup = findViewById(R.id.signup1);
        cancel = findViewById(R.id.cancel);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = getSharedPreferences("UserInfo", 0);
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                if (usernameValue.length() > 1) {

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.apply();
                    Intent loginScreen=new Intent(Signup.this,MainActivity.class);
                    startActivity(loginScreen);
                    Toast.makeText(Signup.this, "User signedin", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Signup.this, "Enter value in the field", Toast.LENGTH_SHORT).show();
                }


            }

        });
        cancel.setOnClickListener((v) -> {

            emptyField();

        });
    }
            public void emptyField() {
                username.setText("");
                password.setText("");
            }
        }



