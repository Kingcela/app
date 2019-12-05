package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }
    public void signUp(View view) {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
    public void login(View view) {
        Intent intent = new Intent(this, student_page.class);
        startActivity(intent);
    }
}
