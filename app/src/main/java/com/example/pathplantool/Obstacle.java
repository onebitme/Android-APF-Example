package com.example.pathplantool;

import com.example.pathplantool.Helpers.UpdatePos;

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


    public void animateObstacle(UpdatePos obstacleAnimate) {
        obstacleAnimate.setPos_x((float)x);
        obstacleAnimate.setPos_y((float)y);
        obstacleAnimate.setPos_theta((float)heading);

        obstacleAnimate.setSp_x((float)x);
        obstacleAnimate.setSp_y((float)y);
        obstacleAnimate.setSp_theta((float)heading);

    }

}
