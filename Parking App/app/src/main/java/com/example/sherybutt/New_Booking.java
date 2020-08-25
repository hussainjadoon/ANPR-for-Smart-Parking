package com.example.sherybutt;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class New_Booking extends AppCompatActivity {
    EditText Display_date;
   EditText Display_time;
   EditText SLOTS;
    Button submit;
    FirebaseAuth auth;
    DatabaseReference DataR;
    DatePickerDialog.OnDateSetListener date_listner;
   // Context mcontext = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting Time
        setContentView(R.layout.activity_new__booking);
        DataR = FirebaseDatabase.getInstance().getReference("Information");
        auth = FirebaseAuth.getInstance();
        Display_time = (EditText) findViewById(R.id.Time);
        Display_date = (EditText) findViewById(R.id.date);
       SLOTS=(EditText)findViewById(R.id.item_select);

        submit = (Button) findViewById(R.id.SUBMIT);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
user_choice();
            }

            public void user_choice() {
                String TIME = Display_time.getText().toString().trim();
                String DATE = Display_date.getText().toString().trim();
               String car_slot=SLOTS.getText().toString().trim();
                FirebaseUser sherdil = auth.getCurrentUser();
                if (TextUtils.isEmpty(TIME)) {
                    Toast.makeText(New_Booking.this, "please no blank area", Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(DATE)) {
                    Toast.makeText(New_Booking.this, "please no blank area", Toast.LENGTH_SHORT).show();

                    return;

                }
                if (TextUtils.isEmpty(car_slot)) {
                    Toast.makeText(New_Booking.this, "please no blank area", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (!TextUtils.isEmpty(DATE) && !TextUtils.isEmpty(TIME)&&!TextUtils.isEmpty(car_slot)) {
                    String id = DataR.push().getKey();
                    //calling constructor parameters....
                    User_Selection user_info = new User_Selection(DATE, TIME, id,car_slot);
                    DataR.child(id).setValue(user_info);
                    Toast.makeText(New_Booking.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(New_Booking.this, "Submission failed...", Toast.LENGTH_SHORT).show();
                    return;

                }


            }
        });
    }
}
