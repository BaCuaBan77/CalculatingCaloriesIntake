package com.example.olole005.calculatingcaloriesintake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ShowResult extends AppCompatActivity  {
    public TextView proteinResult;
    public TextView carboResult;
    public TextView fatResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        proteinResult = findViewById(R.id.protein);
        carboResult =findViewById(R.id.carbo);
        fatResult = findViewById(R.id.fat);
    }
}
