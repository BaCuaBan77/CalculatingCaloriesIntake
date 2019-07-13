package com.example.olole005.calculatingcaloriesintake;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface DesertDAO {
    @Insert
    Long insertDesert(Desert desert);

    @Query("SELECT * FROM desert")
    List<Desert> getAll();

    @Query("SELECT Name FROM desert")
    List<String> getAllName();

    @Query("SELECT * FROM desert WHERE mId =:desertId")
    LiveData<Desert> getTask(int desertId);

    @Query("SELECT Name FROM desert WHERE mId =:desertId")
    String getName(int desertId);

    @Update
    void updateDesert(Desert desert);

    @Delete
    void delete(Desert mainCourse);
}