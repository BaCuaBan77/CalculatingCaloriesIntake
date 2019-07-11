package com.example.olole005.calculatingcaloriesintake;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Appetizer.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppetizerDAO appetizerDAO();
}