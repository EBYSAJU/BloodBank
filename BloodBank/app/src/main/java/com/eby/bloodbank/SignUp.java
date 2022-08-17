package com.eby.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarsDao;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class SignUp extends AppCompatActivity {
    public static  final String EXTRA_username="username";
    public static  final String EXTRA_password="password";
Button login,register,centerLogin,loginCenter;
EditText username,password;
String userName,userPassword;
public  static final String EXTRA_id ="id";
public static  String idSignedIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login=findViewById(R.id.signup_login);
        register=findViewById(R.id.signup_register);
        username=findViewById(R.id.signup_username);
        password=findViewById(R.id.signup_password);
        userName=username.getText().toString();
        userPassword=password.getText().toString();
        centerLogin=findViewById(R.id.signup_registration_center);
        centerLogin.setOnClickListener(v->{
            Intent intent =new Intent(this,CenterRegisteration.class);
            startActivity(intent);
        });
        loginCenter=findViewById(R.id.center_login);
        loginCenter.setOnClickListener(v->{
            Intent intent =new Intent(this,CenterHome.class);
            startActivity(intent);
        });

        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        final DonarsDao donarsDao = database.donarsDao();

        register.setOnClickListener(v->{

            Intent intent=new Intent(this,Registration.class);
            startActivity(intent);


        });
        login.setOnClickListener(v->{
           AppDatabase.databaseWriteExecutor.execute(()->{
                boolean status=donarsDao.authentication(username.getText().toString(),password.getText().toString());
               if(username.getText().toString().isEmpty()||password.getText().toString().isEmpty()){
                   runOnUiThread(()->{

                       Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show();

                   });
               }else {
                   if(status){
                       idSignedIN=String.valueOf(donarsDao.id(username.getText().toString(),password.getText().toString()));

                     //  Intent intent=new Intent(this,DonarDisplay.class);
                       Intent intent=new Intent(this,UserView.class);
                       intent.putExtra(EXTRA_username,username.getText().toString())
                               .putExtra(EXTRA_password,password.getText().toString())
                               .putExtra(EXTRA_id,idSignedIN);
                       startActivity(intent);
                   }
                   else{
                       runOnUiThread(()->{

                           Toast.makeText(this, "Please check the password or username entered", Toast.LENGTH_SHORT).show();

                       });




                   }

               }


            });



        });



    }
}