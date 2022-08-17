package com.eby.bloodbank.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.eby.bloodbank.db.dao.DonarCenterDao;
import com.eby.bloodbank.db.dao.DonarsDao;
import com.eby.bloodbank.db.entity.DonarCenters;
import com.eby.bloodbank.db.entity.Donars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Donars.class, DonarCenters.class},version = 1)

public abstract  class AppDatabase extends RoomDatabase {
public abstract DonarsDao donarsDao();
public abstract DonarCenterDao donarsCenterDao();


    private static  final int NUMBER_OF_THREADS=2;
    public static  final ExecutorService databaseWriteExecutor=
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile AppDatabase instance;
    public static  AppDatabase getDatabaseInstance(final Context context){
        if (instance==null){
            synchronized (AppDatabase.class){
                if (instance==null){
                    instance= Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "app_database")
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return instance;
    }
}
