package com.example.olole005.calculatingcaloriesintake;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

@Database(entities = {Appetizer.class, MainCourse.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppetizerDAO appetizerDAO();
    public abstract MainCourseDAO mainCourseDAO();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE maincourse (mId INTEGER NOT NULL, Name TEXT, Protein REAL NOT NULL, Carbo REAL NOT NULL, Fat REAL NOT NULL, PRIMARY KEY(mId))");
        }
    };
}