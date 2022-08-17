package com.eby.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarCenterDao;
import com.eby.bloodbank.db.dao.DonarsDao;
import com.eby.bloodbank.db.entity.DonarCenters;

import java.util.Random;
import java.util.UUID;

public class CenterRegisteration extends AppCompatActivity {
    EditText centerName,centerAddress,phoneNumber,username,password;
    Button centerSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        final DonarCenterDao donarscenterDao = database.donarsCenterDao();
        setContentView(R.layout.activity_center_registeration);
        centerName=findViewById(R.id.center_registration_name);
        centerAddress=findViewById(R.id.center_registration_address);
        phoneNumber=findViewById(R.id.center_registration_phonenumber);
        centerSubmit=findViewById(R.id.center_registration_submit);
        username=findViewById(R.id.center_donar_username);
        password=findViewById(R.id.center_donar_password);
        centerSubmit.setOnClickListener(v->{

            AppDatabase.databaseWriteExecutor.execute(() -> {

                Random random = new Random();
               int uniqueID= random.nextInt(900) + 100;
                DonarCenters newCenter=new DonarCenters(uniqueID,username.getText().toString(),password.getText().toString(),centerName.getText().toString(),centerAddress.getText().toString(),phoneNumber.getText().toString());
                donarscenterDao.insert(newCenter);
                runOnUiThread(() -> Toast.makeText(this, "new user has been successfully inserted", Toast.LENGTH_LONG).show());
                Intent intent=new Intent(this,CenterDisplay.class);
                startActivity(intent);
            });


        });


    }
}