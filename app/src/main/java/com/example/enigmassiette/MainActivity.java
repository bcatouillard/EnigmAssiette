package com.example.enigmassiette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        Button loginButton = findViewById(R.id.submitButton);
        EditText inputEmail = findViewById(R.id.editTextEmail);
        EditText inputPassword = findViewById(R.id.editTextPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputEmail.getText() != null && inputPassword.getText() != null) {
                    String email = inputEmail.getText().toString();
                    String password = inputPassword.getText().toString();
                    signIn(email, password);
                } else {
                    Log.w(TAG, "emptyCredentials");
                    Toast.makeText(MainActivity.this, "Fill all the inputs with your credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            try {
                                Intent routing = new Intent(MainActivity.this, NoteActivity.class);
                                startActivity(routing);
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.w(TAG, "signIngWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}