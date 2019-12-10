package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {
    EditText userName, passWord;
    Button login;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        db = new DatabaseHelper(this);
        userName = findViewById(R.id.studentUN);
        passWord = findViewById(R.id.studentPW);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString();
                String pass = passWord.getText().toString();
                Boolean userExist = db.userNameAndPassword(user, pass);
                if (userExist) {
                    Intent intent = new Intent(DisplayMessageActivity.this, student_page.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong user name or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void signUp(View view) {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
    public void loginAsTA(View view) {
        Intent intent = new Intent (this, ta_login.class);
        startActivity(intent);
    }
}
