package com.vkt4u9999.taxiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class PassengerSignInActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;

    private Button loginSignUpButton;
    private TextView toggleLoginSignUpTextView;

    private boolean loginModeActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_sign_in);

        textInputEmail=findViewById(R.id.textInputEmail);
        textInputName=findViewById(R.id.textInputName);
        textInputPassword=findViewById(R.id.textInputPassword);
        textInputConfirmPassword=findViewById(R.id.textInputConfirmPassword);

        loginSignUpButton=findViewById(R.id.loginSignUpButton);
        toggleLoginSignUpTextView=findViewById(R.id.toggleLoginSignUpTextView);

    }

    private boolean validateEmail(){
        String emailInput=textInputEmail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()){
            textInputEmail.setError("Please input your email");
            return false;
        }else{
            textInputEmail.setError("");
            return true;
        }
    }

    private boolean validateName(){
        String nameInput=textInputName.getEditText().getText().toString().trim();
        if (nameInput.isEmpty()){
            textInputName.setError("Please input your name");
            return false;
        }else if (nameInput.length()>15){
            textInputName.setError("Name length have to be less then 15");
            return false;
        }
        else{
            textInputName.setError("");
            return true;
        }
    }


    private boolean validatePassword(){
        String passwordInput=textInputPassword.getEditText().getText().toString().trim();
        String confirmPasswordInput=textInputConfirmPassword.getEditText().getText().toString().trim();


        if (passwordInput.isEmpty()){
            textInputPassword.setError("Please input your password");
            return false;
        }else if (passwordInput.length()<7){
            textInputPassword.setError("Password length have to be more then 6");
            return false;
        }else if (!passwordInput.equals(confirmPasswordInput)){
            textInputPassword.setError("Passwords have to match");
            return false;
        }
        else{
            textInputPassword.setError("");
            return true;
        }
    }

    public void loginSignUpUser(View view) {

        if (!validateEmail() | !validateName() | !validatePassword()){
            return;
        }
        String userInput= "Email: "+ textInputEmail.getEditText().getText().toString().trim()+ "\n"
                +"Name: "+ textInputName.getEditText().getText().toString().trim()+ "\n"
                +"Password: "+ textInputPassword.getEditText().getText().toString().trim();

        Toast.makeText(this,userInput,Toast.LENGTH_LONG).show();
    }
    public void toggleLogInSignUp(View view) {
        if (loginModeActive){
            loginModeActive=false;
            loginSignUpButton.setText("Sign Up");
            toggleLoginSignUpTextView.setText("Or, log in");
            textInputConfirmPassword.setVisibility(View.VISIBLE);
            textInputName.setVisibility(View.VISIBLE);

        }else{
            loginModeActive=true;
            loginSignUpButton.setText("Log in");
            toggleLoginSignUpTextView.setText("Or, sign up");
            textInputName.setVisibility(View.GONE);
            textInputConfirmPassword.setVisibility(View.GONE);
        }
    }
}