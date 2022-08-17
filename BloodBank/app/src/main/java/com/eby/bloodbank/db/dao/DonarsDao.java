package com.eby.bloodbank.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.eby.bloodbank.db.entity.Donars;

import java.util.List;

@Dao
public interface DonarsDao {
    @Insert
    void insert(Donars donars);
    @Query("select * from donars")
    List<Donars> getAllUsers();
    @Query("select * from donars where id!=:id")
    List<Donars> getAllUsernames(int id);
    @Query("select * from donars where user_name=:username and password=:password")
    boolean authentication(String username,String password);
    @Query("select id from donars where user_name=:username and password=:password")
    int id(String username,String password);
    @Query("select first_name from donars where id=:id")
    String getFirstname(int id);
    @Query("select gender from donars where id=:id")
    String getGender(int id);
    @Query("select blood_group from donars where id=:id")
    String getBloodGroup(int id);





}
