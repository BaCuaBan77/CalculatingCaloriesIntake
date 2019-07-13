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

    @Query("SELECT * FROM mainCourse WHERE mId =:maincourseId")
    LiveData<MainCourse> getTask(int maincourseId);

    @Query("SELECT Name FROM mainCourse WHERE mId =:maincourseId")
    String getName(int maincourseId);

    @Update
    void updateMainCourse(MainCourse mainCourse);

    @Delete
    void delete(MainCourse mainCourse);
}
