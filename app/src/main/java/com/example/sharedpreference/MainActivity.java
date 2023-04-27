package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login,signup;
    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        preferences = getSharedPreferences("UserInfo", 0);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue=username.getText().toString();
                String passwordValue=password.getText().toString();
                String signupUsername=preferences.getString("username","");
                String signupPassword=preferences.getString("password","");
                if(usernameValue.equals(signupUsername)&&passwordValue.equals(signupPassword)){
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Signup.class);
                startActivity(intent);
            }
        });
    }
}