package com.example.olole005.calculatingcaloriesintake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.olole005.calculatingcaloriesintake.Repositories.AppetizerRepository;
import com.example.olole005.calculatingcaloriesintake.Repositories.DesertRepository;
import com.example.olole005.calculatingcaloriesintake.Repositories.MainCourseRepository;

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

    //DesertList Fields
    private Spinner desert1;
    private Spinner desert2;
    private EditText desertQuantity1;
    private EditText desertQuantity2;

    //Array Adapter
    ArrayAdapter<String> appetizerAdapter;
    ArrayAdapter<String> mainCourseAdapter;
    ArrayAdapter<String> desertAdapter;

    //Drop Down List items
    List<String> AppetizerList = new ArrayList<>();
    List<String> MainCourseList = new ArrayList<>();
    List<String> DesertList = new ArrayList<>();

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

        //Add element to Desert Drop Down View
        DesertList.add("None");
        DesertRepository desertRepository = new DesertRepository(getApplicationContext());
        List<String> desertNames = desertRepository.getAllName();
        DesertList.addAll(desertNames);

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
        mainCourseQuantity2 = findViewById(R.id.MainCourseQuantity2);
        mainCourseQuantity3 = findViewById(R.id.MainCourseQuantity3);

        //Find view by ID with Desert
        desert1 = findViewById(R.id.Desert1);
        desert2 = findViewById(R.id.Desert2);
        desertQuantity1 = findViewById(R.id.DesertQuantity1);
        desertQuantity2 = findViewById(R.id.DesertQuantity2);

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

        //Set elements to Desert DropDownView
        desertAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, DesertList);
        desertAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desert1.setAdapter(desertAdapter);
        desert2.setAdapter(desertAdapter);
    }
}
