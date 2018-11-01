package com.example.dell.myfirebaseapp.UI;

import android.content.Intent;
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

public class UserRegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etxtFname,etxtLname,etxtEmail,etxtMobile,etxtPassword;
    Button btnSubmit,btnSignIn;
    User user;
    private FirebaseAuth mAuth;

    void initViews(){
        etxtFname=findViewById(R.id.editTextFirstName);
        etxtLname=findViewById(R.id.editTexLastName);
        etxtEmail=findViewById(R.id.editTextEmail);
        etxtMobile=findViewById(R.id.editTextMobile);
        etxtPassword=findViewById(R.id.editTextPassword);
        btnSubmit=findViewById(R.id.buttonSubmit);
        user= new User();
        btnSubmit.setOnClickListener(this);
        btnSignIn=findViewById(R.id.buttonSignIn);
        btnSignIn.setOnClickListener(this);





    }
    void RegisterUserOnFirebase(){
        mAuth.createUserWithEmailAndPassword(user.Email,user.Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign up success, update UI with the signed-in user's information
                    Toast.makeText(UserRegistrationActivity.this,"Signed in Successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(UserRegistrationActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // If sign up fails, display a message to the user.
                    Toast.makeText(UserRegistrationActivity.this,"User not Created, some error occured",Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        mAuth = FirebaseAuth.getInstance();
        initViews();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonSubmit) {
            user.FirstName = etxtFname.getText().toString();
            user.LastName = etxtLname.getText().toString();
            user.Email = etxtEmail.getText().toString();
            user.Mobile = etxtMobile.getText().toString();
            user.Password = etxtPassword.getText().toString();
            RegisterUserOnFirebase();
        }
        else if(v.getId()==R.id.buttonSignIn){
            Intent intent=new Intent(UserRegistrationActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
