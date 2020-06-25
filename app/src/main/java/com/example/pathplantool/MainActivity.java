package com.example.pathplantool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton;

    PotentialField potentialCalculator = new PotentialField();
    double[] toDraw = new double[7];

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickListeners();

        potentialCalculator.initALL();

        //System.out.println(benidene.calculateRepulsive());
        //System.out.println(benidene.calculateAttractive());

        toDraw = potentialCalculator.calculatePotentials();

    }

    public void setOnClickListeners(){
        startButton = findViewById(R.id.buttonTest);
    }
}
