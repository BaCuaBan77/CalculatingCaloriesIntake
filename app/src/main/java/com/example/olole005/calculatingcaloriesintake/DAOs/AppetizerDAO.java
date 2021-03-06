package com.example.olole005.calculatingcaloriesintake.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.example.olole005.calculatingcaloriesintake.Enities.Appetizer;
import java.util.List;

@Dao
public interface AppetizerDAO {

    @Insert
    Long insertAppetizer(Appetizer appetizer);

    @Query("SELECT * FROM appetizer")
    List<Appetizer> getAll();

    @Query("SELECT Name FROM appetizer")
    List<String> getAllName();

    @Query("SELECT * FROM appetizer WHERE Name LIKE :name")
    LiveData<Appetizer> getTask(String name);

    @Query("SELECT Name FROM appetizer WHERE Name LIKE :name")
    String getName(String name);

    @Query("SELECT Protein FROM appetizer WHERE Name LIKE :name")
    float getProtein(String name);

    @Query("SELECT Carbo FROM appetizer WHERE Name LIKE :name")
    float getCarbo(String name);

    @Query("SELECT Fat FROM appetizer WHERE Name LIKE :name")
    float getFat(String name);

    @Query("DELETE FROM appetizer")
    public void deleteAll();

    @Update
    void updateAppetizer(Appetizer appetizer);

    @Delete
    void delete(Appetizer appetizer);
}

