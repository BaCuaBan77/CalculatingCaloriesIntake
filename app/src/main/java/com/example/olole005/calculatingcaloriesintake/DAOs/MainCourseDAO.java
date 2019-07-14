package com.example.olole005.calculatingcaloriesintake.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.example.olole005.calculatingcaloriesintake.Enities.MainCourse;

import java.util.List;

@Dao
public interface MainCourseDAO {
    @Insert
    Long insertMainCourse(MainCourse mainCourse);

    @Query("SELECT * FROM mainCourse")
    List<MainCourse> getAll();

    @Query("SELECT Name FROM mainCourse")
    List<String> getAllName();

    @Query("SELECT * FROM maincourse WHERE Name LIKE :name")
    LiveData<MainCourse> getTask(String name);

    @Query("SELECT Name FROM maincourse WHERE Name LIKE :name")
    String getName(String name);

    @Query("SELECT Protein FROM maincourse WHERE Name LIKE :name")
    float getProtein(String name);

    @Query("SELECT Carbo FROM maincourse WHERE Name LIKE :name")
    float getCarbo(String name);

    @Query("SELECT Fat FROM maincourse WHERE Name LIKE :name")
    float getFat(String name);

    @Query("DELETE FROM maincourse")
    public void deleteAll();

    @Update
    void updateMainCourse(MainCourse mainCourse);

    @Delete
    void delete(MainCourse mainCourse);
}
