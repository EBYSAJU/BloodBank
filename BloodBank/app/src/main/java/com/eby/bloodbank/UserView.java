package com.eby.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarsDao;
import com.eby.bloodbank.db.entity.Donars;

import java.util.Calendar;
import java.util.List;

public class UserView extends AppCompatActivity {
    EditText userName,gender,group,centercode;
    Button viewAll;
    Button register;
    public static final String EXTRA_Logged_in="id";
    public  static final String EXTRA_center_code="code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        userName=findViewById(R.id.logged_in_donar_name);
        viewAll=findViewById(R.id.logged_in_view_all);
        gender=findViewById(R.id.logged_in_donar_gender);
        group=findViewById(R.id.logged_in_donar_group);
        register=findViewById(R.id.center_code_register);
        centercode=findViewById(R.id.center_code_value);


        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        final DonarsDao donarsDao = database.donarsDao();
        register.setOnClickListener(v->{
Log.e("hello","hello");



String id=centercode.getText().toString();
           // DialogFragment newFragment = new TimePickerFragmentImpl();
          //  newFragment.show(getSupportFragmentManager(), "timePicker");
            Intent intent=new Intent(this,UserCenterRegister.class);
            intent.putExtra(EXTRA_center_code,id);
            startActivity(intent);







        });

        viewAll.setOnClickListener(v->{
            Intent intent=getIntent();
            Intent newintent=new Intent(this,DonarDisplay.class);
            newintent.putExtra(EXTRA_Logged_in,intent.getStringExtra(SignUp.EXTRA_id));
            startActivity(newintent);
        });
        AppDatabase.databaseWriteExecutor.execute(() -> {
            Intent intent=getIntent();
            String id= intent.getStringExtra(SignUp.EXTRA_id);

          String firstname= donarsDao.getFirstname(Integer.valueOf(id));

        userName.setText(firstname);
        gender.setText(donarsDao.getGender(Integer.valueOf(id)));
        group.setText(donarsDao.getBloodGroup(Integer.valueOf(id)));

        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.appbar,menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.appBarMenu_centers_view:
                Intent intent=new Intent(this,CenterDisplay.class);
                startActivity(intent);
                break;

            default:
                throw new UnsupportedOperationException("New menu item not implemented");
        }
        return true;
    }





}