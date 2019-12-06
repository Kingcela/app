package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    DatabaseHelper db;
    EditText newUN, newPW, newCPW;
    Button newRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        newUN = findViewById(R.id.newUN);
        newPW = findViewById(R.id.newPW);
        newCPW = findViewById(R.id.newCPW);
        newRegister = findViewById(R.id.newRegister);
        newRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = newUN.getText().toString();
                String password = newPW.getText().toString();
                String cPassword = newCPW.getText().toString();
                if (UserName.equals("") || password.equals("") || cPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(cPassword)) {
                        Boolean checkUN = db.checkUserName(UserName);
                        if (checkUN) {
                            Boolean checkInsert = db.insert(UserName, password);
                            if (checkInsert) {
                                Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(register.this, DisplayMessageActivity.class);
                                startActivity(intent);
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "User already exits", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "passWord do not match to each other", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
