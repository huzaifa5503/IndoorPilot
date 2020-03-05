package com.nuces.indoorpilot;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nuces.indoorpilot.base.AbstractDrawerActivity;

public class LoginActivity extends AbstractDrawerActivity {
    TextView signuptext;
    EditText user,pass;
    Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user= (EditText) findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.password);
        signuptext= (TextView) findViewById(R.id.toptext);
        loginbtn=(Button)findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = user.getText().toString();
                String userpassword = pass.getText().toString();
                if(useremail.equals("admin")&&userpassword.equals("123456")){
                    Intent intent=new Intent(LoginActivity.this,ScanActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Credentials incorrect try again!",Toast.LENGTH_SHORT).show();
                }


            }
        });
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Pacifico.ttf");
        signuptext.setTypeface(custom_font);
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public String getCustomTitle() {
        return "Login";
    }
}
