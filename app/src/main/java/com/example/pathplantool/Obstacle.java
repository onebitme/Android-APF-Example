package com.example.pathplantool;

public class Obstacle {
    double x;
    double y;
    double diameter;
    double velocity;
    double heading;

    public  void setObstacleCoordinate (double obsX, double obsY){
        x = obsX;
        y = obsY;
    }
    public void setObstacleDiameter (double obsDiameter){
        diameter = obsDiameter;
    }

    public void setObstacleHeading(double obsHeading){
        heading = obsHeading;
    }

}
