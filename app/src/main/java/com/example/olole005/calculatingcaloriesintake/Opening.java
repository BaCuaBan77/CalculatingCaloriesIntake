package com.example.olole005.calculatingcaloriesintake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class Opening extends AppCompatActivity {

    public Button Calculating;
    public Button CreateNewFood;
    public Button Exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        Calculating = findViewById(R.id.Calculating);
        CreateNewFood = findViewById(R.id.CreateNewFood);
        Exit = findViewById(R.id.Exit);

        View.OnClickListener calculate =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculateActivity();

            }
        };

        Calculating.setOnClickListener(calculate);

        View.OnClickListener createNewFood = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddNewFoodActitity();
            }

        };
        CreateNewFood.setOnClickListener(createNewFood);

        View.OnClickListener ExitButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        };
        Exit.setOnClickListener(ExitButton);




    }
    public void openAddNewFoodActitity(){
        Intent intent = new Intent(this, AddNewFood.class );
        startActivity(intent);
    }

    public void openCalculateActivity(){
         Intent intent = new Intent(this, Calculate.class);
         startActivity(intent);
    }
}
