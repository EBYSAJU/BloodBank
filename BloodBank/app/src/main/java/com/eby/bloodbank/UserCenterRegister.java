package com.eby.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarCenterDao;

public class UserCenterRegister extends AppCompatActivity {
    EditText centername,phonenumber;
    Button scheduleAppointment,scheduleTime;
    String centercode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center_register);
        centername=findViewById(R.id.user_center_name);
        phonenumber=findViewById(R.id.user_center_phoneNumber);
        scheduleAppointment=findViewById(R.id.user_center_schedule);
        scheduleTime=findViewById(R.id.user_center_time);
        Intent intent=getIntent();
       centercode= intent.getStringExtra(UserView.EXTRA_center_code);
        Log.e("centercode",centercode);
        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        final DonarCenterDao donarcentersDao = database.donarsCenterDao();
        AppDatabase.databaseWriteExecutor.execute(() -> {
            String centerName=donarcentersDao.getCenterName(Integer.valueOf(centercode));
            String phoneNumber=donarcentersDao.phoneNumber(Integer.valueOf(centercode));
            centername.setText(centerName);
            phonenumber.setText(phoneNumber);


        });
        scheduleAppointment.setOnClickListener(v->{

            DialogFragment newFragment = new DatePickerFragmentImpl();
            newFragment.show(getSupportFragmentManager(), "datePicker");

        });
        scheduleTime.setOnClickListener(v->{

             DialogFragment newFragment = new TimePickerFragmentImpl();
             newFragment.show(getSupportFragmentManager(), "timePicker");

        });


    }


}