package com.example.olole005.calculatingcaloriesintake.Enities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "appetizer")
public class Appetizer implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "Name")
    public String mName;

    @ColumnInfo(name = "Protein")
    public float mProtein;

    @ColumnInfo(name = "Carbo")
    public float mCarbo;

    @ColumnInfo(name = "Fat")
    public float mFat;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public float getmProtein() {
        return mProtein;
    }

    public void setmProtein(float mProtein) {
        this.mProtein = mProtein;
    }

    public float getmCarbo() {
        return mCarbo;
    }

    public void setmCarbo(float mCarbo) {
        this.mCarbo = mCarbo;
    }

    public float getmFat() {
        return mFat;
    }

    public void setmFat(float mFat) {
        this.mFat = mFat;
    }
}
