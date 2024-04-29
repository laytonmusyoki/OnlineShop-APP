package com.example.onlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        TextView login=findViewById(R.id.register);
        EditText emailInput=findViewById(R.id.email);
        EditText passwordInput=findViewById(R.id.password);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailInput.getText().toString();
                String password=passwordInput.getText().toString();
                if(TextUtils.isEmpty(email)){
                    emailInput.setError("Email field is required");
                    emailInput.requestFocus();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailInput.setError("Please enter a valid email");
                    emailInput.requestFocus();
                } else if (TextUtils.isEmpty(password)) {
                    passwordInput.setError("Password field is required");
                    passwordInput.requestFocus();
                }
                else{
                    if (!email.equals("laytonmatheka7@gmail.com")){
                        emailInput.setError("Wrong email address please try again");
                        emailInput.requestFocus();
                    }
                    else {
                        if (!password.equals("admin")){
                            passwordInput.setError("Wrong password please try again or reset your password");
                            passwordInput.requestFocus();
                        }
                        else {
                            button.setText("Loading...");
                            Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}