package com.example.pathplantool;

import android.util.Log;
import android.widget.ImageView;

import com.example.trustvehicle.Helpers.UpdatePos;

public class DummyRobot {

    double diameter;
    double mass;
    double x;
    double y;
    double velocityX;
    double velocityY;
    double heading;
    double goalX;
    double goalY;
    double timeStamp;

    public void setRobotCoordinates(double xInitial, double yInitial){
        x = xInitial;
        y = yInitial;
    }

    public void setRobotMass(double robotMass){
        mass = robotMass;
    }

    public void setRobotGoal(double robotGoalX, double robotGoalY){
        goalX = robotGoalX;
        goalY = robotGoalY;
    }
    public void setRobotHeading(double robotHeading){
        heading = robotHeading;
    }
    public void setRobotVelocity(double velocityRobotX, double velocityRobotY){
        velocityX=velocityRobotX;
        velocityY = velocityRobotY;
    }

    public void setRobotDiameter(double robotDiameter) {
        diameter = robotDiameter;
    }

    public void setRobotTime(double robotTimeStamp) {
        timeStamp = robotTimeStamp;
    }

    public void initALL(double robotX, double robotY, double goalX, double goalY, double obsX, double obsY) {
        setRobotCoordinates(robotX, robotY);
        setRobotGoal(goalX, goalY);
        setRobotDiameter(10);
        setRobotMass(1000);
        setRobotVelocity(0, 0);
        setRobotHeading(0);
        setRobotTime(0);
    }

    public void animateRobot(UpdatePos robotAnimate) {
        robotAnimate.setPos_x((float)x);
        robotAnimate.setPos_y((float)y);
        robotAnimate.setPos_theta((float)heading);


        robotAnimate.setSp_x((float)x);
        robotAnimate.setSp_y((float)y);
        robotAnimate.setSp_theta((float)heading);

    }

}
