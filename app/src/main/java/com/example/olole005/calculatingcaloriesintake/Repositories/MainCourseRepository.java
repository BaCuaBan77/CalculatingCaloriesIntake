package com.example.olole005.calculatingcaloriesintake.Repositories;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.example.olole005.calculatingcaloriesintake.AppDatabase;
import com.example.olole005.calculatingcaloriesintake.Enities.MainCourse;

import java.util.List;

import static com.example.olole005.calculatingcaloriesintake.AppDatabase.MIGRATION_1_2;
import static com.example.olole005.calculatingcaloriesintake.AppDatabase.MIGRATION_2_3;

public class MainCourseRepository {
    private AppDatabase appDatabase;
    public MainCourseRepository (Context context) {
        String DB_NAME = "db_task";
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).allowMainThreadQueries().addMigrations(MIGRATION_1_2, MIGRATION_2_3).build();
    }

    public void insertMainCourse (String name, float protein, float carbo, float fat) {
        MainCourse mainCourse = new MainCourse();
        mainCourse.setmName(name);
        mainCourse.setmProtein(protein);
        mainCourse.setmCarbo(carbo);
        mainCourse.setmFat(fat);
        insertMainCourse(mainCourse);
    }

    public void insertMainCourse(final MainCourse mainCourse) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.mainCourseDAO().insertMainCourse(mainCourse);
                return null;
            }
        }.execute();
    }

    public void updateMainCourse(final MainCourse mainCourse) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.mainCourseDAO().updateMainCourse(mainCourse);
                return null;
            }
        }.execute();
    }

    public void deleteTask(final int id) {
        final LiveData<MainCourse> task = getMainCourse(id);
        if(task != null) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    appDatabase.mainCourseDAO().delete(task.getValue());
                    return null;
                }
            }.execute();
        }
    }

    public LiveData<MainCourse> getMainCourse(int id) {
        return appDatabase.mainCourseDAO().getTask(id);
    }

    public String getMainCourseName (int id) {
        return appDatabase.mainCourseDAO().getName(id);
    }

    public List<String> getAllName() {
        return appDatabase.mainCourseDAO().getAllName();
    }
}
