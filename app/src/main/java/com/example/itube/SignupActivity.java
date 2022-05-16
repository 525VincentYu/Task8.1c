package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText fullname, username, password, comfirmpassword;
    Button createAccount;
    Database1 DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fullname = findViewById(R.id.fullnamesignup);
        username = findViewById(R.id.usernamesignup);
        password = findViewById(R.id.passwordsignup);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        comfirmpassword = findViewById(R.id.comfirmsignup);
        comfirmpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        createAccount = findViewById(R.id.createaccount);
        DB = new Database1(this);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String full = fullname.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = comfirmpassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")||full.equals(""))
                    Toast.makeText(SignupActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(user,pass,full);

                            if(insert == true){
                                Toast.makeText(SignupActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(SignupActivity.this,"Registered failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(SignupActivity.this,"user already exists!please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SignupActivity.this,"Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}