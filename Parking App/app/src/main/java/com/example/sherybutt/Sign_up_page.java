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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up_page extends AppCompatActivity {
    EditText email;
    EditText pass;
    EditText confirm_pass;
    EditText name;
    EditText Phone_no;
    Button user_register;
    FirebaseAuth firebaseAuth;
    DatabaseReference dataR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        dataR= FirebaseDatabase.getInstance().getReference("Information").child("details");
        email = (EditText) findViewById(R.id.Email_edit);
        pass = (EditText) findViewById(R.id.Pass_edit);
        user_register = (Button) findViewById(R.id.Register);
        confirm_pass = (EditText) findViewById(R.id.Cnf_pass);
        name = (EditText) findViewById(R.id.Name_person);
        Phone_no = (EditText) findViewById(R.id.phone_no);
        firebaseAuth = FirebaseAuth.getInstance();
        user_register.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                save_info();
            }

            public void save_info() {
                String Mail = email.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String confirm = confirm_pass.getText().toString();
                String Name = name.getText().toString().trim();
                String mobile_no = Phone_no.getText().toString().trim();
                FirebaseUser shery = firebaseAuth.getCurrentUser();

                if (TextUtils.isEmpty(Mail)) {
                    Toast.makeText(Sign_up_page.this, "please no blank area", Toast.LENGTH_SHORT).show();
                    Mail.contains("@");
                    return;
                }

                if (TextUtils.isEmpty(password)&&TextUtils.isEmpty(confirm )){
                    Toast.makeText(Sign_up_page.this, "please no blank area", Toast.LENGTH_SHORT).show();

                    return;

                }//length of password
                    if(password.length()>=6&& (confirm.length()>=6)){
                    }
                    else{
                        Toast.makeText(Sign_up_page.this, "Password length should be 6 characters long", Toast.LENGTH_SHORT).show();

                }
                if(password.equals(confirm)){

                }
                else{
                    Toast.makeText(Sign_up_page.this, "Password doesn't match the confirm password", Toast.LENGTH_SHORT).show();
                }
                if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(mobile_no)) {
                    String id = dataR.push().getKey();
                    //calling constructor parameters....
                    data_insertion info = new data_insertion(Name, mobile_no,Mail,password);
                    dataR.child(id).setValue(info);
                }
                else{

                    Toast.makeText(Sign_up_page.this, "please no blank area", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.getCurrentUser();
                firebaseAuth.createUserWithEmailAndPassword(Mail, password).addOnCompleteListener(Sign_up_page.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(Sign_up_page.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Toast.makeText(Sign_up_page.this, "Couldn't register user", Toast.LENGTH_SHORT).show();
                        }

                    }

                });

            }
        });

    }

}