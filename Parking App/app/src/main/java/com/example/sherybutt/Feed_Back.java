package com.example.sherybutt;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feed_Back extends AppCompatActivity {
    FirebaseAuth Fbase_feed;
    DatabaseReference dataR_feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed__back);
        Fbase_feed = FirebaseAuth.getInstance();
        dataR_feed = FirebaseDatabase.getInstance().getReference("User Feedback");
        EditText ufeed;
        ufeed = (EditText) findViewById(R.id.user_feed);
        Button send_feed;
        send_feed = (Button) findViewById(R.id.send_feedback);
        send_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_feed();
            }
                public void user_feed(){
                String feed_btn = ufeed.getText().toString().trim();
                if (TextUtils.isEmpty(feed_btn)) {
                    Toast.makeText(Feed_Back.this, "please no blank area", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                        String id_feed = dataR_feed.push().getKey();
                        //calling constructor parameters....
                        feed_back_text info = new feed_back_text (feed_btn,id_feed);
                        dataR_feed.child(id_feed).setValue(info);

                        Toast.makeText(Feed_Back.this, "Successfully Sent!", Toast.LENGTH_SHORT).show();
                        return;


                }
            }


        });

    }
}
