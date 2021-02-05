package com.vkt4u9999.taxiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DriverSignInActivity extends AppCompatActivity {

    private static final String TAG = "DriverSignInActivity";
    

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;

    private Button loginSignUpButton;
    private TextView toggleLoginSignUpTextView;

    private boolean loginModeActive;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sign_in);

        textInputEmail=findViewById(R.id.textInputEmail);
        textInputName=findViewById(R.id.textInputName);
        textInputPassword=findViewById(R.id.textInputPassword);
        textInputConfirmPassword=findViewById(R.id.textInputConfirmPassword);

        loginSignUpButton=findViewById(R.id.loginSignUpButton);
        toggleLoginSignUpTextView=findViewById(R.id.toggleLoginSignUpTextView);


        auth= FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null){
            startActivity(new Intent(DriverSignInActivity.this, DriverMapsActivity.class));
        }

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

        if (passwordInput.isEmpty()){
            textInputPassword.setError("Please input your password");
            return false;
        }else if (passwordInput.length()<7){
            textInputPassword.setError("Password length have to be more then 6");
            return false;
        }else{
            textInputPassword.setError("");
            return true;
        }
    }
    private boolean validateConfirmPassword(){
        String passwordInput=textInputPassword.getEditText().getText().toString().trim();
        String confirmPasswordInput=textInputConfirmPassword.getEditText().getText().toString().trim();


        if (!passwordInput.equals(confirmPasswordInput)){
            textInputPassword.setError("Passwords have to match");
            return false;
        }else{
            textInputPassword.setError("");
            return true;
        }
    }


    public void loginSignUpUser(View view) {

        if (!validateEmail() | !validatePassword()){
            return;
        }
        if (loginModeActive) {
            auth.signInWithEmailAndPassword(textInputEmail.getEditText().getText().toString().trim(), textInputPassword.getEditText().getText().toString().trim())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInInWithEmail:success");
                                FirebaseUser user = auth.getCurrentUser();
                                startActivity(new Intent(DriverSignInActivity.this, DriverMapsActivity.class));

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInUserInWithEmail:failure", task.getException());
                                Toast.makeText(DriverSignInActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }else {
            if (!validateEmail() | !validateName() | !validatePassword() | !validateConfirmPassword()){
                return;
            }
            auth.createUserWithEmailAndPassword(textInputEmail.getEditText().getText().toString().trim(), textInputPassword.getEditText().getText().toString().trim())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserInWithEmail:success");
                                FirebaseUser user = auth.getCurrentUser();
                                startActivity(new Intent(
                                        DriverSignInActivity.this,
                                        DriverMapsActivity.class
                                ));

                            } else {

                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserInWithEmail:failure", task.getException());
                                Toast.makeText(DriverSignInActivity.this, "Failed to create new user.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }
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
