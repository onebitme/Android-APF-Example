package com.example.pathplantool;

import androidx.appcompat.app.AppCompatActivity;
import com.example.pathplantool.Helpers.PathView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startButton, stopButton;
    PathView pathViewPath;

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
        toDraw = potentialCalculator.calculatePotentials();

        pathViewPath = findViewById(R.id.pathViewPath);
        pathViewPath.updatePath();

    }
    public void onClick(View v){

        Handler handler1 = new Handler();

        if (v == startButton){

            for (int i=1; i<=10; i++){
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Geri Sayım: ");
                    }
                },200*i);
            }

        }
        else if (v == stopButton){
            for (int i=1; i<=10; i++){
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("İleri Sayım: ");
                    }
                },200*i);
            }

        }
    }

    public void setOnClickListeners(){
        startButton = findViewById(R.id.StartAnimation);
        stopButton = findViewById(R.id.buttonTest2);

        startButton.setOnClickListener(this);

    }

}
