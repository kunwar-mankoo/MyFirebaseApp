package com.example.dell.myfirebaseapp.UI;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.dell.myfirebaseapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView txt=findViewById(R.id.name);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        txt.startAnimation(animation);
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser user=mAuth.getCurrentUser();
        if (user!=null){
            handler.sendEmptyMessageDelayed(201,5000);
        }
        else{
            handler.sendEmptyMessageDelayed(101,5000);

        }

    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==101){
                Intent intent = new Intent(SplashActivity.this,UserRegistrationActivity.class);
                startActivity(intent);
                finish();
            }
            else if(msg.what==201){
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    } ;
}
