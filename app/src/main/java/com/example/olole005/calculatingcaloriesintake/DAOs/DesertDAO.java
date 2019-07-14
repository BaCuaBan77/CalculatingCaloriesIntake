package com.example.olole005.calculatingcaloriesintake.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.example.olole005.calculatingcaloriesintake.Enities.Desert;
import java.util.List;

@Dao
public interface DesertDAO {

    @Insert
    Long insertDesert(Desert desert);

    @Query("SELECT * FROM desert")
    List<Desert> getAll();

    @Query("SELECT Name FROM desert")
    List<String> getAllName();

    @Query("SELECT * FROM desert WHERE Name LIKE :name")
    LiveData<Desert> getTask(String name);

    @Query("SELECT Name FROM desert WHERE Name LIKE :name")
    String getName(String name);

    @Query("SELECT Protein FROM desert WHERE Name LIKE :name")
    float getProtein(String name);

    @Query("SELECT Carbo FROM desert WHERE Name LIKE :name")
    float getCarbo(String name);

    @Query("SELECT Fat FROM desert WHERE Name LIKE :name")
    float getFat(String name);

    @Query("DELETE FROM desert")
    void deleteAll();

    @Update
    void updateDesert(Desert desert);

    @Delete
    void delete(Desert mainCourse);
}