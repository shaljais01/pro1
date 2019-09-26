package com.example.pro1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MessActivity extends AppCompatActivity {

    Button bt_enterFood,bt_updateProfile,bt_viewReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess);
        bt_enterFood=findViewById(R.id.enter_food);
        bt_updateProfile=findViewById(R.id.update_profile);
        bt_viewReview=findViewById(R.id.view_review);
        
    }
}
