package com.example.olole005.calculatingcaloriesintake;

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
    public EditText nameOfTheFood;
public EditText proteinIntake;
public EditText carboIntake;
public EditText fatIntake;
public Button add;
public Spinner chooseTypeOfFood;



    List<Appetizer> appetizers = new ArrayList<>();
    List<MainCourse> mainCourses =new ArrayList<>();
    List<Desert> deserts = new ArrayList<>();




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




                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });









    }

}
