package com.example.pro1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button login,signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login=findViewById(R.id.Login);
        signUp=findViewById(R.id.SignUp);
    }
}
