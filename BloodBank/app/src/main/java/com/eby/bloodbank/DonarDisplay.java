package com.eby.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarsDao;
import com.eby.bloodbank.db.entity.Donars;
import com.eby.bloodbank.recylerview.DonarAdapter;

import java.util.ArrayList;
import java.util.List;

public class DonarDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_display);
        RecyclerView myList = findViewById(R.id.main_recyclerView);
        myList.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Donars> donars = new ArrayList<>();
        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        final DonarsDao donarsDao = database.donarsDao();
       DonarAdapter adapter = new DonarAdapter();
        myList.setAdapter(adapter);

        AppDatabase.databaseWriteExecutor.execute(() -> {
            Intent intent=getIntent();
           // String id= intent.getStringExtra(SignUp.EXTRA_id);
            String id= intent.getStringExtra(UserView.EXTRA_Logged_in);

            List<Donars> allUsernames = donarsDao.getAllUsernames(Integer.valueOf(id));
            adapter.add(allUsernames);

        });




    }
}