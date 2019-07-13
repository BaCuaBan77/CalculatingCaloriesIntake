package com.example.olole005.calculatingcaloriesintake.Repositories;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.example.olole005.calculatingcaloriesintake.AppDatabase;
import com.example.olole005.calculatingcaloriesintake.Enities.Appetizer;

import java.util.List;

import static com.example.olole005.calculatingcaloriesintake.AppDatabase.MIGRATION_1_2;
import static com.example.olole005.calculatingcaloriesintake.AppDatabase.MIGRATION_2_3;

public class AppetizerRepository {
    private AppDatabase appDatabase;
    public AppetizerRepository (Context context) {
        String DB_NAME = "db_task";
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).allowMainThreadQueries().addMigrations(MIGRATION_1_2, MIGRATION_2_3).build();
    }

    public void insertAppetizer (String name, float protein, float carbo, float fat) {
       Appetizer appetizer = new Appetizer();
       appetizer.setmName(name);
       appetizer.setmProtein(protein);
       appetizer.setmCarbo(carbo);
       appetizer.setmFat(fat);
       insertAppetizer(appetizer);
    }

    public void insertAppetizer(final Appetizer appetizer) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.appetizerDAO().insertAppetizer(appetizer);
                return null;
            }
        }.execute();
    }

    public void updateAppetizer(final Appetizer appetizer) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.appetizerDAO().updateAppetizer(appetizer);
                return null;
            }
        }.execute();
    }

    public void deleteTask(final int id) {
        final LiveData<Appetizer> task = getAppetizer(id);
        if(task != null) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    appDatabase.appetizerDAO().delete(task.getValue());
                    return null;
                }
            }.execute();
        }
    }

    public LiveData<Appetizer> getAppetizer(int id) {
        return appDatabase.appetizerDAO().getTask(id);
    }

    public String getAppetizerName (int id) {
        return appDatabase.appetizerDAO().getName(id);
    }

    public List<String> getAllName() {
        return appDatabase.appetizerDAO().getAllName();
    }
}
