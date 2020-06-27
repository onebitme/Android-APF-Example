package com.example.pathplantool;

import androidx.appcompat.app.AppCompatActivity;
import com.example.pathplantool.Helpers.PathView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startButton, stopButton, setRobotPos;
    EditText setRobotX, setRobotY, goalRobotX, goalRobotY;
    PathView pathViewPath;
    PotentialField potentialCalculator = new PotentialField();

    DummyRobot robot;

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

        potentialCalculator.initALL(50,50,50,50,100,100);

        robot = potentialCalculator.getRobot();
        potentialCalculator.setTimeStep(0);

        System.out.println("ESozen: Ive created a robot: " + robot.x + "//" + robot.y );

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
            potentialCalculator.initALL(50,50, intRobotX, intRobotY, intGoalX,intGoalY);
            System.out.println("Initialized Robot: " + robot.x + " //  "+ robot.goalY);
        }
        else if (v == startButton){

            robot = potentialCalculator.getRobot();
            System.out.println("StartAnim Robot: " + robot.x + "//" + robot.y + " And Goals are" + robot.goalX + "//" + robot.goalY);
            System.out.println("Initial Time Step: " + robot.timeStep);

            for (robot.timeStep = 0; robot.timeStep<100; robot.timeStep = robot.timeStep + 5){
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        potentialCalculator.calculatePotentials(robot, robot.timeStep);
                        System.out.println("For Loop : " + robot.x + " " + robot.y + "Robot TimeStep: " + robot.timeStep);
                        pathViewPath.updatePath();
                    }
                },200);
            }

        }
        else if (v == stopButton){
            for (int i=1; i<=10; i++){
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("İleri Sayım: ");
                    }
                },200);
            }

        }
    }

    public void setOnClickListeners(){

        startButton = findViewById(R.id.StartAnimation);
        stopButton = findViewById(R.id.buttonTest2);
        setRobotPos = findViewById(R.id.buttonSetCoordinates);

        setRobotX = findViewById(R.id.objX);
        setRobotY = findViewById(R.id.objY);

        goalRobotX = findViewById(R.id.objX2);
        goalRobotY = findViewById(R.id.objY2);


        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        setRobotPos.setOnClickListener(this);

    }

}
