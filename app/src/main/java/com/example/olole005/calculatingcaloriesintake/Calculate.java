package com.example.olole005.calculatingcaloriesintake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Calculate extends AppCompatActivity {
    public Spinner appetizer1;
    public Spinner appetizer2;
    public EditText appetizerQuantity;
    public EditText appetizer2Quantity;
    ArrayAdapter<String> appetizer1Adapter;
    List<String> Appetizer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Appetizer.add("None");
        Appetizer.add("Chicken");
        setContentView(R.layout.activity_calculate);
        appetizer1 = findViewById(R.id.Appertizer1);
        appetizer2 = findViewById(R.id.Appetizer2);
        appetizerQuantity =findViewById(R.id.Appetizer1Quantity);
        appetizer2Quantity = findViewById(R.id.Appetizer2Quantity);
        appetizer1Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Appetizer);
        appetizer1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appetizer1.setAdapter(appetizer1Adapter);
        appetizer2.setAdapter(appetizer1Adapter);
    }


}
