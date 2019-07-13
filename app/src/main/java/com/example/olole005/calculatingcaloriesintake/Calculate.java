package com.example.olole005.calculatingcaloriesintake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Calculate extends AppCompatActivity {
    //AppetizerList Fields
    private Spinner appetizer1;
    private Spinner appetizer2;
    private EditText appetizerQuantity;
    private EditText appetizer2Quantity;
    //MainCourseList Fields
    private Spinner mainCourse1;
    private Spinner mainCourse2;
    private Spinner mainCourse3;
    private EditText mainCourseQuantity1;
    private EditText mainCourseQuantity2;
    private EditText mainCourseQuantity3;
    //Array Adapter
    ArrayAdapter<String> appetizerAdapter;
    ArrayAdapter<String> mainCourseAdapter;
    List<String> AppetizerList = new ArrayList<>();
    List<String> MainCourseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        //Add elements to AppetizerList Drop Down View
        AppetizerList.add("None");
        AppetizerRepository appetizerRepository = new AppetizerRepository(getApplicationContext());
        List<String> appetizerNames = appetizerRepository.getAllName();
        AppetizerList.addAll(appetizerNames);
        //Add elements to Main Course Drop Down View
        MainCourseList.add("None");
        MainCourseRepository mainCourseRepository = new MainCourseRepository(getApplicationContext());
        List<String> mainCourseNames = mainCourseRepository.getAllName();
        MainCourseList.addAll(mainCourseNames);
        //Find view by ID with AppetizerList
        appetizer1 = findViewById(R.id.Appertizer1);
        appetizer2 = findViewById(R.id.Appetizer2);
        appetizerQuantity =findViewById(R.id.Appetizer1Quantity);
        appetizer2Quantity = findViewById(R.id.Appetizer2Quantity);
        //Find view by ID with Main Course
        mainCourse1 = findViewById(R.id.MainCourse1);
        mainCourse2 = findViewById(R.id.MainCourse2);
        mainCourse3 = findViewById(R.id.MainCourse3);
        mainCourseQuantity1 = findViewById(R.id.MainCourseQuantity1);
        mainCourseQuantity1 = findViewById(R.id.MainCourseQuantity2);
        mainCourseQuantity1 = findViewById(R.id.MainCourseQuantity3);
        //Set elements to AppetizerList DropDownView
        appetizerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, AppetizerList);
        appetizerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appetizer1.setAdapter(appetizerAdapter);
        appetizer2.setAdapter(appetizerAdapter);
        //Set elements to MainCourseList DropDownView
        mainCourseAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, MainCourseList);
        mainCourseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainCourse1.setAdapter(mainCourseAdapter);
        mainCourse2.setAdapter(mainCourseAdapter);
        mainCourse3.setAdapter(mainCourseAdapter);

    }
}
