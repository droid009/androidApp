package com.example.root.loginandsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    TextView Login_btn;
    EditText Name, Email, Password, Phone;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name = (EditText) findViewById(R.id.register_name);
        Email = (EditText) findViewById(R.id.register_email);
        Password = (EditText) findViewById(R.id.register_password);
        Phone = (EditText) findViewById(R.id.register_phone);
        Login_btn = (TextView) findViewById(R.id.link_login);
        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
        Register = (Button) findViewById(R.id.btn_signup);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    public boolean validate() {
        boolean valid = true;
        String name = Name.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String phone = Phone.getText().toString();

        if (name.isEmpty() || name.length() < 4) {
            Name.setError("at lest 4 characters");
            valid = false;
        } else {
            Name.setError(null);
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("enter a valid email address");
            valid = false;
        } else {
            Email.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            Password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            Password.setError(null);
        }
        if (!phone.matches("[a-zA-Z]+")) {
            if (phone.length() != 10) {
                // if(phone.length() != 10) {
                valid = false;
                Phone.setError("Please Enter 10 Digit Number  ");
            } else {
                valid = true;
            }
        } else {
            valid = false;
        }
        return valid;
    }
}