package com.eby.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarsDao;
import com.eby.bloodbank.db.entity.Donars;
import com.eby.bloodbank.recylerview.DonarAdapter;
import com.eby.bloodbank.recylerview.DonarCenterAdapter;
import com.eby.bloodbank.recylerview.DonarViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DonarCenter extends AppCompatActivity {
EditText name,gender,bloodGroup;
Button donate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donar_center_display);
        RecyclerView myList = findViewById(R.id.main_recyclerView);
        myList.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Donars> donars = new ArrayList<>();
        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        final DonarsDao donarsDao = database.donarsDao();
        DonarCenterAdapter adapter = new DonarCenterAdapter();
        myList.setAdapter(adapter);

        AppDatabase.databaseWriteExecutor.execute(() -> {
            Intent intent=getIntent();
            String id= intent.getStringExtra(SignUp.EXTRA_id);
            Log.e("id",SignUp.idSignedIN);

            List<Donars> allUsernames = donarsDao.getAllUsernames(Integer.valueOf(SignUp.idSignedIN));
            adapter.add(allUsernames);

        });





    }
}