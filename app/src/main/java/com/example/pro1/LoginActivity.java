package com.example.pro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

public class LoginActivity extends AppCompatActivity {

    Button bt_login;
    EditText user_name,password;
    String userName,pass,type;
    User user=new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt_login=findViewById(R.id.Bt_login);
        user_name=findViewById(R.id.User_name);
        password=findViewById(R.id.Password);
        Intent intent = getIntent();
        type = intent.getStringExtra("type");

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName=user_name.getText().toString().trim();
                pass=password.getText().toString().trim();
                String url = Constants.IP +
                        "/login?user_name="+ userName+"&password="+password+"&type="+type;
                MyCustomRequest myCustomRequest = new MyCustomRequest(Request.Method.GET,
                        url,User.class, null,
                        new Response.Listener < User > () {
                            @Override
                            public void onResponse(User user2){
                                if(user2.getStatus()==true){
                                    if(user2.getUsertype().equals("Mess")){
                                        Intent intent=new Intent(LoginActivity.this,MessActivity.class);
                                        LoginActivity.this.startActivity(intent);
                                    }
                                    else if(user2.getUsertype().equals("NGO")){
                                        Intent intent=new Intent(LoginActivity.this,NGOActivity.class);

                                        LoginActivity.this.startActivity(intent);
                                    }

                                    else if(user2.getUsertype().equals("Animal")){
                                        Intent intent=new Intent(LoginActivity.this,AnimalActivity.class);

                                        LoginActivity.this.startActivity(intent);}
                                }
                                else{
                                    Toast.makeText(LoginActivity.this, "Wrong user id or password", Toast.LENGTH_SHORT).show();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError response) {
                                //Failure callback
                                Toast.makeText(LoginActivity.this, "Error Encountered", Toast.LENGTH_SHORT).show();
                            }
                        });
                MyApplication.getInstance().addToRequestQueue(myCustomRequest,"kuchbhi");

            }
        });
    }
}
