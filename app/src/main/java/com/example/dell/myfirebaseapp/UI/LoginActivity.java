package com.example.dell.myfirebaseapp.UI;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.myfirebaseapp.Model.User;
import com.example.dell.myfirebaseapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Email;
    EditText Password;
    Button BtnSignIn,BtnSignUp;
    private FirebaseAuth mAuth;

    void initViews(){
        Email=findViewById(R.id.editTextEmail);
        Password=findViewById(R.id.editTextPassword);
        BtnSignIn=findViewById(R.id.buttonSubmit);
        BtnSignIn.setOnClickListener(this);
        BtnSignUp=findViewById(R.id.buttonSignUp);
        BtnSignUp.setOnClickListener(this);
        mAuth=FirebaseAuth.getInstance();

    }

    void LoginWithFireBase(){
        final User user=new User();
        user.Email=Email.getText().toString();
        user.Password=Password.getText().toString();
        mAuth.signInWithEmailAndPassword(user.Email,user.Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    //intent.putExtra(user);
                    startActivity(intent);
                    finish();
                } else {
                    // If sign up fails, display a message to the user.
                    Toast.makeText(LoginActivity.this,"User not Created, some error occured",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonSubmit){
            LoginWithFireBase();
        }
        else if(v.getId()==R.id.buttonSignUp){
            Intent intent=new Intent(LoginActivity.this,UserRegistrationActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
