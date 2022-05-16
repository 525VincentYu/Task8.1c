package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLoign, btnSignUp;
    Database1 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        btnLoign = (Button) findViewById(R.id.buttonLogin);
        btnSignUp = (Button) findViewById(R.id.buttonSignUp);
        DB = new Database1(this);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLoign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();


                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernampassword(user,pass);
                    if(checkuserpass == true){
                        user = username.getText().toString();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);



                        Toast.makeText(MainActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}