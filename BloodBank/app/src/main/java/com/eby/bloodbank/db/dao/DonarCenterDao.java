package com.eby.bloodbank.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.eby.bloodbank.db.entity.DonarCenters;
import com.eby.bloodbank.db.entity.Donars;

import java.util.List;

@Dao
public interface DonarCenterDao {
    @Insert
    void insert(DonarCenters centers);
    @Query("select * from donarcenters ")
    List<DonarCenters> getAllCenters();
    @Query("select * from donarcenters where username=:username and password=:password")
    boolean authentication(String username,String password);
    @Query("select center_name from donarcenters where center_code=:code")
    String getCenterName(int code);
    @Query("select contact_number from donarcenters where center_code=:code")
    String phoneNumber(int code);



}
