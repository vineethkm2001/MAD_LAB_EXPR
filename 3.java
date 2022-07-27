package com.example.signupandin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button sign;
    EditText uname;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String regex ="(?=.[a-z])(?=.[A-Z])"
                +"(?=.*[0-9])"
                +"(?=.*[%@]).{8,20}$";
        Pattern p = Pattern.compile(regex);
         uname = findViewById(R.id.username);
         pass = findViewById(R.id.password);
        sign =  findViewById(R.id.signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pass.getText().toString();
                Matcher m = p.matcher(password);
                if(uname.length()==0 || pass.length()==0){
                    Toast.makeText(getApplicationContext(),"Username or Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(m.matches()== true) {
                        Intent intent = new Intent(MainActivity.this, Login.class);
                        Bundle extras = new Bundle();
                        extras.putString("EXTRA_USERNAME", username);
                        extras.putString("EXTRA_PASSWORD", password);
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Password pattern not matched", Toast.LENGTH_SHORT).show();
                    }
                    }
            }
        });
            }
        }

//////////////////////////////////////////////////////////////////////
package com.example.signupandin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button sign;
    EditText uname;
    EditText pass;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         uname = findViewById(R.id.username);
         pass = findViewById(R.id.password);
        sign =  findViewById(R.id.signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count < 2) {
                    String username = uname.getText().toString();
                    String password = pass.getText().toString();


                    Intent intent = getIntent();
                    Bundle extras = intent.getExtras();
                    String username_string = extras.getString("EXTRA_USERNAME");
                    String password_string = extras.getString("EXTRA_PASSWORD");

                    if (username.equals(username_string) == true && password.equals(password_string) == true) {
                        Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                        count++;
                    }


                }
                else{
                    Toast.makeText(getApplicationContext(), "Too Many Login Attempt please try again later", Toast.LENGTH_SHORT).show();
                    sign.setEnabled(false);
                }
            }
        });
    }
}
