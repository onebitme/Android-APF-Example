package com.example.pathplantool;

import androidx.appcompat.app.AppCompatActivity;
import com.example.pathplantool.Helpers.PathView;
import com.example.trustvehicle.Helpers.UpdatePos;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startButton, stopButton, setRobotPos;
    EditText setRobotX, setRobotY, goalRobotX, goalRobotY;
    PathView pathViewPath;
    PotentialField potentialCalculator = new PotentialField();


    DummyRobot robot = new DummyRobot();
    double timeStamp = 0;

    double[] robotPosGoal = new double[4];

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        setOnClickListeners();
        //initViews();

        ImageView robotView = findViewById(R.id.imageViewRobot);

        pathViewPath = findViewById(R.id.pathViewPath);
        robot.initALL(100,100,50,50, 0,0);
        robot.setRobotTime(0);

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

            robot.setRobotCoordinates(intRobotX,intRobotY);
            robot.setRobotGoal(intGoalX,intGoalY);


            System.out.println("Initialized Robot: " + robot.x + " //  "+ robot.goalY);
        }
        else if (v == startButton){
            System.out.println("StartAnim Robot: " + robot.x + "//" + robot.y + " And Goals are" + robot.goalX + "//" + robot.goalY);
            System.out.println("TimeStep when pressed :" + robot.timeStamp);
            timeStamp=0;

            for (int i=1; i<200; i++){
                final int j=i;
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ImageView robotView = findViewById(R.id.imageViewRobot);
                    robotPosGoal=potentialCalculator.calculatePotentials(robot.x,robot.y,robot.mass,robot.goalX,robot.goalY, 0 ,0, j);
                    robot.setRobotCoordinates(robotPosGoal[0],robotPosGoal[1]);
                    robot.setRobotVelocity(robotPosGoal[2],robotPosGoal[3]);
                    System.out.println("Robot Coordinates" + robot.x + "//"+ robot.y + "Timestamp: " + j);
                    UpdatePos robotAnimate = new UpdatePos(robotView,400f-(float)robot.x ,400f-(float)robot.y, 0f, 400f-(float)robot.x,400f-(float)robot.y, 0f);
                    animateRobot(robotAnimate);
                    pathViewPath.updatePath();
                    }
                },1000*j);
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
/*
    public void initViews(){
        robotView = findViewById(R.id.imageViewRobot);


    }
*/
    public void animateRobot(UpdatePos robotAnimate){
        robotAnimate.setPos_x(400f-10*(float)robot.x);
        robotAnimate.setPos_y(400f-10*(float)robot.y);
        robotAnimate.setPos_theta(400f-10*(float)robot.heading);

        robotAnimate.setSp_x(400f-10*(float)robot.x);
        robotAnimate.setSp_y(400f-10*(float)robot.y);
        robotAnimate.setSp_theta(400f-10*(float)robot.heading);
    }

}
