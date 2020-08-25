package com.example.sherybutt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {
    FirebaseAuth Fbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Fbase = FirebaseAuth.getInstance();
        Button Feed;
        Feed=(Button)findViewById(R.id.feedb);
        Feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_feedback=new Intent(Dashboard.this,Feed_Back.class);
                startActivity(intent_feedback);
            }
        });
        Button details;
        details=(Button)findViewById(R.id.mydetails);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_details=new Intent(Dashboard.this,User_details.class);
                startActivity(intent_details);
            }
        });
        Button New_booking;
        New_booking=(Button)findViewById(R.id.newBooking);
        New_booking.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Dashboard.this,New_Booking.class);
        startActivity(intent);
    }
});
        Button Lout;
        Lout = (Button) findViewById(R.id.Logout);
        Lout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Fbase.signOut();
        onStart();
    }
});

        }
        protected void onStart(){
        super.onStart();
        FirebaseUser user=Fbase.getCurrentUser();
        if(user!=null){

        }else{
            Toast.makeText(Dashboard.this, "Logged out Successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Dashboard.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        }

}


