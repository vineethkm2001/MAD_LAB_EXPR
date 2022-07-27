package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    Boolean Running = false;
    int[] ia=new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.wall);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(!Running)
        {
            new Timer().schedule(new Mytimer(),0,5000);
            Running=true;
        }

    }
    private class Mytimer extends TimerTask {
        public void run()
        {
            try {
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getBaseContext());
                Random random=new Random();
                int randomInt = random.nextInt(5);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),ia[randomInt]);
                wallpaperManager.setBitmap(bitmap);
               }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
