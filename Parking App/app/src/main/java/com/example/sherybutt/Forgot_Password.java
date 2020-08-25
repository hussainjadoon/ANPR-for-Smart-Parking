package com.example.sherybutt;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);
        EditText link_email;
        Button Enter;
        link_email=(EditText)findViewById(R.id.link);
        Enter=(Button)findViewById(R.id.goto_link);
        FirebaseAuth fireAuth;
        fireAuth=FirebaseAuth.getInstance();
       Enter .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recover_pass();
            }
                public void recover_pass(){
                  String LE=link_email.getText().toString().trim();
                     if (TextUtils.isEmpty(LE)) {
                    Toast.makeText(Forgot_Password.this, "please enter correct email", Toast.LENGTH_SHORT).show();
                    LE.contains("@");
                }
                    else {
                         fireAuth.sendPasswordResetEmail(LE).addOnCompleteListener(new OnCompleteListener<Void>() {
                             @Override
                             public void onComplete(@NonNull Task<Void> task) {
                                 if (task.isSuccessful()) {

                                     Toast.makeText(Forgot_Password.this, "visit your email to reset your password", Toast.LENGTH_SHORT).show();

                                 } else {
                                     Toast.makeText(Forgot_Password.this, "Error!", Toast.LENGTH_SHORT).show();

                                 }
                             }

                         });

                }

            }
        });
    }
}
