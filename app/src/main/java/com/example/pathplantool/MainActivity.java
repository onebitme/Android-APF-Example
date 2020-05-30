package com.example.pathplantool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    PotentialField benidene = new PotentialField();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        benidene.initALL();

        //System.out.println(benidene.calculateRepulsive());
        //System.out.println(benidene.calculateAttractive());

        benidene.calculatePotentials();

    }
}
