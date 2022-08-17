package com.eby.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarsDao;
import com.eby.bloodbank.db.entity.Donars;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class Registration extends AppCompatActivity {
    EditText date,username,password,confirmPassword,firstName,lastName,bloodGroup,address,gender;
    Button submit;
    String userName,userPassword,firstname,lastname,confirmpassword,donarAddress,donarGender,donarDob,donarBloodGroup;
    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR); // current year
    int mMonth = c.get(Calendar.MONTH); // current month
    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        final DonarsDao donarsDao = database.donarsDao();
        date = findViewById(R.id.registration_date_of_birth);
        username=findViewById(R.id.registration_username);
        password=findViewById(R.id.registration_password);
        confirmPassword=findViewById(R.id.registration_confirmpassword);
        firstName=findViewById(R.id.registration_first_name);
        lastName=findViewById(R.id.registration_last_name);
        bloodGroup=findViewById(R.id.registration_blood_group);
        address=findViewById(R.id.registration_address);
        gender=findViewById(R.id.registration_gender);
        submit=findViewById(R.id.registration_submit);



        date.setOnClickListener(v -> {

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,

                    (view, year, monthOfYear, dayOfMonth) -> {


                        date.setText(new StringBuilder().append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).toString());
                       //date.setText(String.valueOf(year));

                    }, mYear, mMonth, mDay);

            datePickerDialog.show();


        });
        submit.setOnClickListener(v -> {



            userName = username.getText().toString();


            userPassword = password.getText().toString();

            firstname = firstName.getText().toString();
            confirmpassword=confirmPassword.getText().toString();
            donarAddress=address.getText().toString();
            donarGender=gender.getText().toString();
            donarDob=date.getText().toString();
            donarBloodGroup=bloodGroup.getText().toString();

            lastname = lastName.getText().toString();
            if (userName.isEmpty() || userPassword.isEmpty() || firstname.isEmpty() || lastname.isEmpty()) {
                runOnUiThread(() -> Toast.makeText(this, "All fields are Mandatory", Toast.LENGTH_LONG).show());

            } else if (!(userPassword.equals(confirmPassword.getText().toString()))) {
                runOnUiThread(() -> Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show());
            } else {
                Donars newdonar = new Donars(userName, userPassword, firstname, lastname,donarAddress,donarGender,donarBloodGroup,donarDob);
                AppDatabase.databaseWriteExecutor.execute(() -> {

                    donarsDao.insert(newdonar);
                   // runOnUiThread(() -> Toast.makeText(this, "new user has been successfully inserted", Toast.LENGTH_LONG).show());
                 Intent intent=new Intent(this,SignUp.class);
                 startActivity(intent);
                });
            }


        });






    }
}