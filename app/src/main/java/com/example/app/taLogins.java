package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class taLogins extends AppCompatActivity {
    EditText userName, passWord;
    Button login;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ta_logins);
        db = new DatabaseHelper(this);
        userName = findViewById(R.id.TAM);
        passWord = findViewById(R.id.TAP);
        login = findViewById(R.id.taLoginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            // i was trying to deal with the problem about why register as student can still login as ta
            // however, I cannot, I tried to create two table but failed because we got no time for two tables.
            public void onClick(View v) {
                String user = userName.getText().toString();
                String pass = passWord.getText().toString();
                Boolean userExist = db.userNameAndPassword(user, pass);
                if (userExist) {
                    Intent intent = new Intent(taLogins.this, taPages.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong user name or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
