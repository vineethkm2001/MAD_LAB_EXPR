package com.example.texttospeecccch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {
    Button btn_speak;
    EditText txtSpeak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_speak=  findViewById(R.id.btn_speech);
        txtSpeak=  findViewById(R.id.Edt_txt);
        btn_speak.setOnClickListener( this);
        textToSpeech=new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);
    }

    @Override
    public void onInit(int status) {

        if(status !=TextToSpeech.ERROR)
        {
            Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        String text = txtSpeak.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}
