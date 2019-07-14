package com.example.olole005.calculatingcaloriesintake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.olole005.calculatingcaloriesintake.Enities.MainCourse;
import com.example.olole005.calculatingcaloriesintake.Repositories.AppetizerRepository;
import com.example.olole005.calculatingcaloriesintake.Repositories.DesertRepository;
import com.example.olole005.calculatingcaloriesintake.Repositories.MainCourseRepository;

import java.util.ArrayList;
import java.util.List;

public class Calculate extends AppCompatActivity {
    private EditText appetizerQuantity;
    private EditText appetizer2Quantity;

    private EditText mainCourseQuantity1;
    private EditText mainCourseQuantity2;
    private EditText mainCourseQuantity3;

    private EditText desertQuantity1;
    private EditText desertQuantity2;

    //Array Adapter
    ArrayAdapter<String> appetizerAdapter;
    ArrayAdapter<String> mainCourseAdapter;
    ArrayAdapter<String> desertAdapter;

    //Button
    private Button calculateButton;

    //Drop Down List items
    List<String> AppetizerList = new ArrayList<>();
    List<String> MainCourseList = new ArrayList<>();
    List<String> DesertList = new ArrayList<>();

    //Appetizer Value
    private float mProteinValueAppetizer1;
    private float mCarboValueAppetizer1;
    private float mFatValueAppetizer1;
    private String mNameAppetizer1;
    private float mProteinValueAppetizer2;
    private float mCarboValueAppetizer2;
    private float mFatValueAppetizer2;
    private String mNameAppetizer2;

    //MainCourse Value
    private float mProteinValueMainCourse1;
    private float mCarboValueMainCourse1;
    private float mFatValueMainCourse1;
    private String mNameMainCourse1;
    private float mProteinValueMainCourse2;
    private float mCarboValueMainCourse2;
    private float mFatValueMainCourse2;
    private String mNameMainCourse2;
    private float mProteinValueMainCourse3;
    private float mCarboValueMainCourse3;
    private float mFatValueMainCourse3;
    private String mNameMainCourse3;

    //Desert Value
    private float mProteinValueDesert1;
    private float mCarboValueDesert1;
    private float mFatValueDesert1;
    private String mNameDesert1;
    private float mProteinValueDesert2;
    private float mCarboValueDesert2;
    private float mFatValueDesert2;
    private String mNameDesert2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        //Add elements to AppetizerList Drop Down View
        final AppetizerRepository appetizerRepository = new AppetizerRepository(getApplicationContext());
        List<String> appetizerNames = appetizerRepository.getAllName();
        AppetizerList.add("None");
        AppetizerList.addAll(appetizerNames);

        //Add elements to Main Course Drop Down View
        final MainCourseRepository mainCourseRepository = new MainCourseRepository(getApplicationContext());
        List<String> mainCourseNames = mainCourseRepository.getAllName();
        MainCourseList.add("None");
        MainCourseList.addAll(mainCourseNames);

        //Add element to Desert Drop Down View
        final DesertRepository desertRepository = new DesertRepository(getApplicationContext());
        List<String> desertNames = desertRepository.getAllName();
        DesertList.add("None");
        DesertList.addAll(desertNames);

        //Find view by ID with AppetizerList
        //AppetizerList Fields
        Spinner appetizer1 = findViewById(R.id.Appertizer1);
        Spinner appetizer2 = findViewById(R.id.Appetizer2);
        appetizerQuantity =findViewById(R.id.Appetizer1Quantity);
        appetizer2Quantity = findViewById(R.id.Appetizer2Quantity);

        //Find view by ID with Main Course
        //MainCourseList Fields
        Spinner mainCourse1 = findViewById(R.id.MainCourse1);
        Spinner mainCourse2 = findViewById(R.id.MainCourse2);
        Spinner mainCourse3 = findViewById(R.id.MainCourse3);
        mainCourseQuantity1 = findViewById(R.id.MainCourseQuantity1);
        mainCourseQuantity2 = findViewById(R.id.MainCourseQuantity2);
        mainCourseQuantity3 = findViewById(R.id.MainCourseQuantity3);

        //Find view by ID with Desert
        //DesertList Fields
        Spinner desert1 = findViewById(R.id.Desert1);
        Spinner desert2 = findViewById(R.id.Desert2);
        desertQuantity1 = findViewById(R.id.DesertQuantity1);
        desertQuantity2 = findViewById(R.id.DesertQuantity2);

        //Find view by ID Button
        calculateButton = findViewById(R.id.Calculate);

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

        //Get Value of Appetizer1
        appetizer1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <= AppetizerList.size(); i++) {
                    if (position == i) {
                        mNameAppetizer1 = appetizerRepository.getAppetizerName(AppetizerList.get(i));
                        mProteinValueAppetizer1 = appetizerRepository.getProteinValue(AppetizerList.get(i));
                        mCarboValueAppetizer1 = appetizerRepository.getCarboValue(AppetizerList.get(i));
                        mFatValueAppetizer1 = appetizerRepository.getFatValue(AppetizerList.get(i));
                        Log.d("Calculate Appetizer ", mNameAppetizer1 + " : "
                                + mProteinValueAppetizer1 + ", "
                                + mCarboValueAppetizer1 + ", "
                                + mFatValueAppetizer1);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Get Value of Appetizer2
        appetizer2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <= DesertList.size(); i++) {
                    if (position == i) {
                        mNameAppetizer2 = appetizerRepository.getAppetizerName(AppetizerList.get(i));
                        mProteinValueAppetizer2 = appetizerRepository.getProteinValue(AppetizerList.get(i));
                        mCarboValueAppetizer2 = appetizerRepository.getCarboValue(AppetizerList.get(i));
                        mFatValueAppetizer2 = appetizerRepository.getFatValue(AppetizerList.get(i));
                        Log.d("Calculate Appetizer ", mNameAppetizer2 + " : "
                                + mProteinValueAppetizer2 + ", "
                                + mCarboValueAppetizer2 + ", "
                                + mFatValueAppetizer2);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Get Value of MainCourse1
        mainCourse1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <= MainCourseList.size(); i++) {
                    if (position == i) {
                        mNameMainCourse1 = mainCourseRepository.getMainCourseName(MainCourseList.get(i));
                        mProteinValueMainCourse1 = mainCourseRepository.getProteinValue(MainCourseList.get(i));
                        mCarboValueMainCourse1 = mainCourseRepository.getCarboValue(MainCourseList.get(i));
                        mFatValueMainCourse1 = mainCourseRepository.getFatValue(MainCourseList.get(i));
                        Log.d("Calculate MainCourse ", mNameMainCourse1 + " : "
                                + mProteinValueMainCourse1 + ", "
                                + mCarboValueMainCourse1 + ", "
                                + mFatValueMainCourse1);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Get Value of MainCourse2
        mainCourse2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <= MainCourseList.size(); i++) {
                    if (position == i) {
                        mNameMainCourse2 = mainCourseRepository.getMainCourseName(MainCourseList.get(i));
                        mProteinValueMainCourse2 = mainCourseRepository.getProteinValue(MainCourseList.get(i));
                        mCarboValueMainCourse2 = mainCourseRepository.getCarboValue(MainCourseList.get(i));
                        mFatValueMainCourse2 = mainCourseRepository.getFatValue(MainCourseList.get(i));
                        Log.d("Calculate MainCourse ", mNameMainCourse2 + " : "
                                + mProteinValueMainCourse2 + ", "
                                + mCarboValueMainCourse2 + ", "
                                + mFatValueMainCourse2);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Get Value of MainCourse3
        mainCourse1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <= MainCourseList.size(); i++) {
                    if (position == i) {
                        mNameMainCourse3 = mainCourseRepository.getMainCourseName(MainCourseList.get(i));
                        mProteinValueMainCourse3 = mainCourseRepository.getProteinValue(MainCourseList.get(i));
                        mCarboValueMainCourse3 = mainCourseRepository.getCarboValue(MainCourseList.get(i));
                        mFatValueMainCourse3 = mainCourseRepository.getFatValue(MainCourseList.get(i));
                        Log.d("Calculate MainCourse ", mNameMainCourse3 + " : "
                                + mProteinValueMainCourse3 + ", "
                                + mCarboValueMainCourse3 + ", "
                                + mFatValueMainCourse3);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Get value of desert1
        desert1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <= DesertList.size(); i++) {
                    if (position == i) {
                        mNameDesert1 = desertRepository.getDesertName(DesertList.get(i));
                        mProteinValueDesert1 = desertRepository.getProteinValue(DesertList.get(i));
                        mCarboValueDesert1 = desertRepository.getCarboValue(DesertList.get(i));
                        mFatValueDesert1 = desertRepository.getFatValue(DesertList.get(i));
                        Log.d("Calculate Desert ", mNameDesert1 + " : "
                                + mProteinValueDesert1 + ", "
                                + mCarboValueDesert1 + ", "
                                + mFatValueDesert1);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Get Value of Desert2
        desert2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <= DesertList.size(); i++) {
                    if (position == i) {
                        mNameDesert2 = desertRepository.getDesertName(DesertList.get(i));
                        mProteinValueDesert2 = desertRepository.getProteinValue(DesertList.get(i));
                        mCarboValueDesert2 = desertRepository.getCarboValue(DesertList.get(i));
                        mFatValueDesert2 = desertRepository.getFatValue(DesertList.get(i));
                        Log.d("Calculate Desert ", mNameDesert2 + " : "
                                + mProteinValueDesert2 + ", "
                                + mCarboValueDesert2 + ", "
                                + mFatValueDesert2);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Calculating Button
        calculateButton.setOnClickListener(calculateCalories);
    }

    View.OnClickListener calculateCalories = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
