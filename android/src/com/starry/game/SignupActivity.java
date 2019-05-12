package com.starry.game;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends Activity {

    private EditText email;
    private EditText name;
    private EditText password;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = (EditText)findViewById(R.id.signupActivity_email);
        name = (EditText)findViewById(R.id.signupActivity_name);
        password = (EditText)findViewById(R.id.signupActivity_password);
        signup = (Button) findViewById(R.id.signupActivity_button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString() == null || name.getText().toString() == null
                        || password.getText().toString() == null) {
                    return;
                }

                FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                String uid = task.getResult().getUser().getUid();
                            }
                        });
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                //finish();

            }
        });

        findViewById(R.id.signupActivity_button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, AndroidLauncher.class);
                startActivity(intent);

            }
        });
    }
}
