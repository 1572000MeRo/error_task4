package com.reload.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class LogInActivity extends AppCompatActivity {


    public static final Pattern PASSWORD_PATTERN=Pattern.compile("^" +
           // "(?=.*[0-9])" +         //at least 1 digit
           // "(?=.*[a-z])" +         //at least 1 lower case letter
           // "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{4,}" +               //at least 4 characters
            "$");


Button signup,login;
TextInputLayout textInput_email,textInput_username,textInput_password;
EditText edt_email,edt_username,edt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        textInput_email=findViewById(R.id.text_input_email);
        textInput_username=findViewById(R.id.text_input_username);
        textInput_password=findViewById(R.id.text_input_password);

        edt_email=findViewById(R.id.edt_email);
        edt_username=findViewById(R.id.edt_username);
        edt_password=findViewById(R.id.edt_password);
        login=findViewById(R.id.btn_login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Login();
//                validateEmail();
//                validatePassword();
            }
        });


        signup=findViewById(R.id.btn_account);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    private boolean validateEmail(){
        String emailinput=textInput_email.getEditText().getText().toString().trim();
        if(emailinput.isEmpty())
        {
            textInput_email.setError("Field can't be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()){
            textInput_email.setError("please enter a valid email");
            return false;
        }
        else{
            textInput_email.setError(null);
            return true;

        }

    }
    private boolean validatePassword(){
        String passwordinput=textInput_password.getEditText().getText().toString().trim();
        if(passwordinput.isEmpty()){
            textInput_password.setError("Field can't be empty");
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(passwordinput).matches()){
            textInput_password.setError("password too weak");
            return false;
        }

        else {
            textInput_password.setError(null);
            return true;

        }
    }


    private void Login()
    {

        if(!validateEmail() | !validatePassword())
        {
          return;
        }
       String input = "Email: " +textInput_email.getEditText().getText().toString();
        input +="\n";
        input += "Password: " + textInput_password.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(LogInActivity.this , MainActivity2.class);
        startActivity(intent);

}

    }

