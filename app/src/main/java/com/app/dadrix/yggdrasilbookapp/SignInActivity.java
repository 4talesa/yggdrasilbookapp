package com.app.dadrix.yggdrasilbookapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class SignInActivity extends YggdrasilBookActivity {

    public List<String> permissions;

    TextView textViewsSignInEmail;
    TextView textViewsSignInPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        permissions = new ArrayList<String>();
        permissions.add("public_profile");
        permissions.add("user_status");
        permissions.add("user_friends");

        /*
        ParseUser user = new ParseUser();
        user.setUsername("UserSignIn");
        user.setPassword("passSignIn");
        user.setEmail("email@example.com");

        // other fields can be set just like with ParseObject
        user.put("phone", "650-555-0000");

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });

        */

        textViewsSignInEmail = (TextView) findViewById(R.id.textViewsSignInEmail);
        textViewsSignInPassword = (TextView) findViewById(R.id.textViewsSignInPassword);

        Button buttonSignIn = (Button) findViewById(R.id.buttonSignInAct);
        Button buttonSignUp = (Button) findViewById(R.id.buttonOrSignUp);
        Button buttonFacebookSignIn = (Button) findViewById(R.id.buttonFacebookSignIn);
        ImageButton imageViewFacebookSignIn = (ImageButton) findViewById(R.id.imageViewFacebookSignIn);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(v.getContext(), SignUpActivity.class);

                v.getContext().startActivity(it);
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser.logInInBackground(textViewsSignInEmail.getText().toString(), textViewsSignInPassword.getText().toString(), new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // Hooray! The user is logged in.
                            Intent it = new Intent(SignInActivity.this, BookBrowseActivity.class);

                            SignInActivity.this.startActivity(it);
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                            Context context = getApplicationContext();
                            CharSequence text = e.toString();
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    }
                });

            }
        });

        buttonFacebookSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseFacebookUtils.logInWithReadPermissionsInBackground(SignInActivity.this, permissions, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException err) {
                        if (user == null) {
                            Log.d("MyApp", "Uh oh. The user cancelled the Facebook login.");
                        } else if (user.isNew()) {
                            Log.d("MyApp", "User signed up and logged in through Facebook!");
                            Intent it = new Intent(SignInActivity.this, BookBrowseActivity.class);

                            SignInActivity.this.startActivity(it);
                        } else {
                            Log.d("MyApp", "User logged in through Facebook!");
                            Intent it = new Intent(SignInActivity.this, BookBrowseActivity.class);

                            SignInActivity.this.startActivity(it);
                        }
                    }
                });
            }
        });

        imageViewFacebookSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ParseFacebookUtils.logInWithReadPermissionsInBackground(SignInActivity.this, permissions, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException err) {
                        if (user == null) {
                            Log.d("MyApp", "Uh oh. The user cancelled the Facebook login.");
                        } else if (user.isNew()) {
                            Log.d("MyApp", "User signed up and logged in through Facebook!");
                            Intent it = new Intent(SignInActivity.this, BookBrowseActivity.class);

                            SignInActivity.this.startActivity(it);
                        } else {
                            Log.d("MyApp", "User logged in through Facebook!");
                            Intent it = new Intent(SignInActivity.this, BookBrowseActivity.class);

                            SignInActivity.this.startActivity(it);
                        }
                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed() {

        /*Intent it = new Intent(SignInActivity.this, WelcomeActivity.class);
        SignInActivity.this.startActivity(it);
        */
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }
}
