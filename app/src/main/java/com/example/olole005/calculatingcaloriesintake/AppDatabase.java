package com.example.olole005.calculatingcaloriesintake;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

@Database(entities = {Appetizer.class, MainCourse.class, Desert.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppetizerDAO appetizerDAO();
    public abstract MainCourseDAO mainCourseDAO();
    public abstract DesertDAO desertDAO();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE maincourse (mId INTEGER NOT NULL, Name TEXT," +
                    " Protein REAL NOT NULL, Carbo REAL NOT NULL, Fat REAL NOT NULL, PRIMARY KEY(mId))");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE desert (mId INTEGER NOT NULL, Name TEXT," +
                    " Protein REAL NOT NULL, Carbo REAL NOT NULL, Fat REAL NOT NULL, PRIMARY KEY(mId))");
        }
    };

}