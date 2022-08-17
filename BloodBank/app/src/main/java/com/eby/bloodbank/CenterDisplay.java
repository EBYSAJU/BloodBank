package com.eby.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarCenterDao;
import com.eby.bloodbank.db.dao.DonarsDao;
import com.eby.bloodbank.db.entity.DonarCenters;
import com.eby.bloodbank.db.entity.Donars;
import com.eby.bloodbank.recylerview.CenterAdapter;
import com.eby.bloodbank.recylerview.DonarAdapter;
import com.eby.bloodbank.recylerview.DonarCenterAdapter;

import java.util.ArrayList;
import java.util.List;

public class CenterDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_display);
        RecyclerView myList = findViewById(R.id.main_recyclerView);
        myList.setLayoutManager(new LinearLayoutManager(this));
        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        ArrayList<DonarCenters> centers = new ArrayList<>();
        final DonarCenterDao donarcentersDao = database.donarsCenterDao();
        CenterAdapter adapter = new CenterAdapter();
        myList.setAdapter(adapter);
        AppDatabase.databaseWriteExecutor.execute(() -> {

            List<DonarCenters> allCenters = donarcentersDao.getAllCenters();
           adapter.add(allCenters);

        });




    }
}