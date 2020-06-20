package com.example.pathplantool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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

        potentialCalculator.initALL();

        //System.out.println(benidene.calculateRepulsive());
        //System.out.println(benidene.calculateAttractive());

        toDraw = potentialCalculator.calculatePotentials();

    }
}
