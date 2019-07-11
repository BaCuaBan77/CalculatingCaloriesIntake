package com.example.olole005.calculatingcaloriesintake;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface AppetizerDAO {
    @Query("SELECT * FROM appetizer")
    List<Appetizer> getAll();

    @Query("SELECT * FROM appetizer WHERE mId IN (:userIds)")
    List<Appetizer> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM appetizer WHERE Name LIKE :first")
    Appetizer findByName(String first);

    @Insert
    void insertAll(Appetizer... users);

    @Delete
    void delete(Appetizer user);
}

