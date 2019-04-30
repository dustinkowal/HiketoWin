package com.e.hiketowin;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button buttonLogin;
    Button buttonCreate;
    TextInputEditText textInputEmail;
    TextInputEditText textInputPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonCreate = (Button) findViewById(R.id.buttonCreateAccount);
        textInputEmail = (TextInputEditText) findViewById(R.id.textInputEmail);
        textInputPassword = (TextInputEditText) findViewById(R.id.textInputPassword);

        mAuth = FirebaseAuth.getInstance();

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewUser();
            }
        });
    }

    private void createNewUser(){
        String email = textInputEmail.getText().toString();
        String password = textInputPassword.getText().toString();

        //mAuth.createUserWithEmailAndPassword(email, password)

    }
}
