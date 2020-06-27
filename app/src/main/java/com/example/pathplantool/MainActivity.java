package com.example.pathplantool;

import androidx.appcompat.app.AppCompatActivity;
import com.example.pathplantool.Helpers.PathView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.pathplantool.PotentialField.robot;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startButton, stopButton, setRobotPos;
    EditText setRobotX, setRobotY, goalRobotX, goalRobotY;
    PathView pathViewPath;
    PotentialField potentialCalculator = new PotentialField();

    DummyRobot robot;

    double[] toDraw = new double[12];

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickListeners();
        pathViewPath = findViewById(R.id.pathViewPath);


    }
    public void onClick(View v){
        Handler handler1 = new Handler();

        if (v == setRobotPos){
            int intRobotX, intRobotY, intGoalX, intGoalY;
            String RobotX = setRobotX.getText().toString();
            intRobotX = Integer.parseInt(RobotX);
            String RobotY = setRobotY.getText().toString();
            intRobotY = Integer.parseInt(RobotY);
            String GoalX = goalRobotX.getText().toString();
            intGoalX = Integer.parseInt(GoalX);
            String GoalY = goalRobotY.getText().toString();
            intGoalY = Integer.parseInt(GoalY);

            robot.x = intRobotX;
            robot.y = intRobotY;

        }
        else if (v == startButton){

            for (int i=1; i<=10; i++){
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(robot.x);
                        potentialCalculator.initALL();
                        potentialCalculator.calculatePotentials();
                        pathViewPath.updatePath();
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
        setRobotPos = findViewById(R.id.buttonSetCoordinates);

        setRobotX = findViewById(R.id.objX);
        setRobotY = findViewById(R.id.objY);

        goalRobotX = findViewById(R.id.objX);
        goalRobotY = findViewById(R.id.objY);


        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        setRobotPos.setOnClickListener(this);

    }

}
