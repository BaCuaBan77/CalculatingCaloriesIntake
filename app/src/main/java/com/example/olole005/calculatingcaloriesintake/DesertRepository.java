package com.example.olole005.calculatingcaloriesintake;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import static com.example.olole005.calculatingcaloriesintake.AppDatabase.MIGRATION_1_2;
import static com.example.olole005.calculatingcaloriesintake.AppDatabase.MIGRATION_2_3;

public class DesertRepository {
    private AppDatabase appDatabase;
    public DesertRepository (Context context) {
        String DB_NAME = "db_task";
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).allowMainThreadQueries().addMigrations(MIGRATION_1_2, MIGRATION_2_3).build();
    }

    public void insertDesert (String name, float protein, float carbo, float fat) {
        Desert desert = new Desert();
        desert.setmName(name);
        desert.setmProtein(protein);
        desert.setmCarbo(carbo);
        desert.setmFat(fat);
        insertDesert(desert);
    }

    public void insertDesert(final Desert desert) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.desertDAO().insertDesert(desert);
                return null;
            }
        }.execute();
    }

    public void updateDesert(final Desert desert) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.desertDAO().updateDesert(desert);
                return null;
            }
        }.execute();
    }

    public void deleteTask(final int id) {
        final LiveData<Desert> task = getDesert(id);
        if(task != null) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    appDatabase.desertDAO().delete(task.getValue());
                    return null;
                }
            }.execute();
        }
    }

    public LiveData<Desert> getDesert(int id) {
        return appDatabase.desertDAO().getTask(id);
    }

    public String getDesertName (int id) {
        return appDatabase.desertDAO().getName(id);
    }

    public List<String> getAllName() {
        return appDatabase.desertDAO().getAllName();
    }
}
