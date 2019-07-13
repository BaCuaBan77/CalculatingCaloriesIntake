package com.example.olole005.calculatingcaloriesintake;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddNewFood extends AppCompatActivity {
    ArrayAdapter<CharSequence> chooseTypeOfFoodAdapter;
    private EditText nameOfTheFood;
    private EditText proteinIntake;
    private EditText carboIntake;
    private EditText fatIntake;
    private Button add;
    private Spinner chooseTypeOfFood;
    private int positionSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_food);
        nameOfTheFood = findViewById(R.id.nameOfTheFood);
        proteinIntake = findViewById(R.id.proteinIntake);
        carboIntake = findViewById(R.id.carboIntake);
        fatIntake = findViewById(R.id.fatIntake);
        add = findViewById(R.id.Add);
        chooseTypeOfFood = findViewById(R.id.ChooseTypeFoodToAdd);
        //spinner initialize
        chooseTypeOfFoodAdapter= ArrayAdapter.createFromResource(this, R.array.food_to_choose, android.R.layout.simple_spinner_item);
        chooseTypeOfFoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chooseTypeOfFood.setAdapter(chooseTypeOfFoodAdapter);
        chooseTypeOfFood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    positionSelected = 0;
                }
                else if (position == 1) {
                    positionSelected = 1;
                }
                else if (position == 2 ) {
                    positionSelected = 2;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        add.setOnClickListener(addFood);
    }


    View.OnClickListener addFood = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AppetizerRepository appetizerRepository = new AppetizerRepository(getApplicationContext());
            MainCourseRepository mainCourseRepository = new MainCourseRepository(getApplicationContext());
            DesertRepository desertRepository = new DesertRepository(getApplicationContext());
            if (positionSelected == 0) {
                String name = String.valueOf(nameOfTheFood.getText());
                float protein = Float.parseFloat(proteinIntake.getText().toString());
                float carbo = Float.parseFloat(carboIntake.getText().toString());
                float fat = Float.parseFloat(fatIntake.getText().toString());
                appetizerRepository.insertAppetizer(name, protein, carbo, fat);
            }
            else if (positionSelected == 1) {
                String name = String.valueOf(nameOfTheFood.getText());
                float protein = Float.parseFloat(proteinIntake.getText().toString());
                float carbo = Float.parseFloat(carboIntake.getText().toString());
                float fat = Float.parseFloat(fatIntake.getText().toString());
                mainCourseRepository.insertMainCourse(name, protein, carbo, fat);
            }
            else if (positionSelected == 2) {
                String name = String.valueOf(nameOfTheFood.getText());
                float protein = Float.parseFloat(proteinIntake.getText().toString());
                float carbo = Float.parseFloat(carboIntake.getText().toString());
                float fat = Float.parseFloat(fatIntake.getText().toString());
                desertRepository.insertDesert(name, protein, carbo, fat);
            }
        }
    };


}
