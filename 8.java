package com.example.cs2dailer;


import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button call_button,save_button;
    EditText phoneNumberEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call_button=(Button)findViewById(R.id.CALL);
        save_button=(Button)findViewById(R.id.SAVE);
        phoneNumberEditText=(EditText)findViewById(R.id.Phone_Number);
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_intent=new Intent(Intent.ACTION_DIAL);
                call_intent.setData(Uri.parse("tel:"+phoneNumberEditText.getText().toString()));
                startActivity(call_intent);
            }
        });
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,phoneNumberEditText.getText().toString());
                startActivity(intent);
            }
        });
    }
    public void entered_number(View V){
        Button button=(Button) V;
        String digit=button.getText().toString();
        String phoneNumber=phoneNumberEditText.getText().toString();
        phoneNumberEditText.setText(phoneNumber+digit);
    }
}
