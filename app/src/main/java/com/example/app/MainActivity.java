package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer hellow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hellow = MediaPlayer.create(MainActivity.this, R.raw.welcome);
    }
    public void studentLog(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
    public void taLog(View view) {
        Intent intent = new Intent (this, taLogins.class);
        startActivity(intent);
    }
    public void playIT(View view) {
        hellow.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        hellow.release();
    }
}
