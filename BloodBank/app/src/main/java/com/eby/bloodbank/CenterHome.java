package com.eby.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarCenterDao;
import com.eby.bloodbank.db.entity.DonarCenters;
import com.eby.bloodbank.db.entity.Donars;

import java.util.ArrayList;
import java.util.List;

public class CenterHome extends AppCompatActivity {
EditText username,password;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_home);
        username=findViewById(R.id.signup_centername);
        password=findViewById(R.id.signup_password);
        login=findViewById(R.id.signup_sign_in);
        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        final DonarCenterDao donarcentersDao = database.donarsCenterDao();
        login.setOnClickListener(v->{


            AppDatabase.databaseWriteExecutor.execute(() -> {
                boolean status=donarcentersDao.authentication(username.getText().toString(),password.getText().toString());
                if(status){
                    Intent intent=new Intent(this,CenterDisplay.class);
                    startActivity(intent);
                }

            });
        });




    }
}