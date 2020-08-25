package com.example.sherybutt;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class User_details extends AppCompatActivity {
    DatabaseReference dataR;
    FirebaseUser user;
    FirebaseDatabase Fdatabase;
    ListView initializeL;
    String uid;
    Button userInfo;
    List<String> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        user= FirebaseAuth.getInstance().getCurrentUser();
        initializeL = (ListView) findViewById(R.id.dataview);
        Fdatabase=FirebaseDatabase.getInstance();
        uid=user.getUid();
        userInfo=(Button) findViewById(R.id.mydetails);



            FirebaseDatabase.getInstance().getReference().child("details").child(uid).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    array.clear();
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(User_details.this, android.R.layout.simple_list_item_1, array);
                    String data_email = dataSnapshot.child(uid).child("datab_email").getValue().toString();
                    String data_number = dataSnapshot.child(uid).child("datab_name").getValue().toString();
                    String data_name = dataSnapshot.child(uid).child("datab_number").getValue().toString();
                    String data_password = dataSnapshot.child(uid).child("datab_password").getValue().toString();

                    array.add(data_email);
                    array.add(data_number);
                    array.add(data_name);
                    array.add(data_password);


                    initializeL.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }



        });
    };

}


