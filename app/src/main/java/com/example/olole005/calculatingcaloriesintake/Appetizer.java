package com.example.olole005.calculatingcaloriesintake;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Appetizer {
    @PrimaryKey
    public int mId;

    @ColumnInfo(name = "Name")
    public String mName;

    @ColumnInfo(name = "Protein")
    public float mProtein;

    @ColumnInfo(name = "Carbo")
    public float mCarbo;

    @ColumnInfo(name = "Fat")
    public float mFat;


}
