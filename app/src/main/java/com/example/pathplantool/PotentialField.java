package com.example.pathplantool;

import android.util.Pair;

import java.util.ArrayList;

public class PotentialField {

    //Sets Obstacle Attr
    static Obstacle obs = new Obstacle();
    static DummyRobot robot = new DummyRobot();

    public  void setObstacleCoordinate (double x, double y){
        obs.x = x;
        obs.y = y;
    }
    public void setObstacleVelocity (double velocity){
        obs.velocity = velocity;
    }
    public void setObstacleDiameter (double diameter){
        obs.diameter = diameter;
    }
    public void setObstacleHeading(double heading){
        obs.heading = heading;
    }
    public void calculateObs(Obstacle obs){
        obs.x = obs.velocity*Math.cos(obs.heading);
        obs.y = obs.velocity*Math.sin(obs.heading);
    }

    //Set Robot Attribute
    public void setRobotCoordinates(double xInitial, double yInitial){
        robot.x = xInitial;
        robot.y = yInitial;
    }
    public void setRobotDiameter(double dRobot){
        robot.diameter = dRobot;
    }
    public void setRobotGoal(double goalX, double goalY){
        robot.goalX = goalX;
        robot.goalY = goalY;
    }
    public void setRobotMass(double mass){
        robot.mass = mass;
    }
    public void setRobotVelocity(double velocityX, double velocityY){
        robot.velocityX = velocityX;
        robot.velocityY = velocityY;
    }
    public void setRobotHeading(double heading){
        robot.heading = heading;
    }

    //Repulsive Cost
    double KR = 1;
    //Attractive Cost
    double KA = 1;

    public void initALL(){
        setObstacleCoordinate(95,94);
        setRobotCoordinates(101,101);
        setRobotDiameter(10);
        setRobotGoal(88,85);
        setRobotMass(1000);
        setRobotVelocity(0,0);
        setObstacleHeading(0);
        setRobotHeading(0);
    }

    //Where everything is calculated
    public double[] calculateRepulsive(){
        double[] repulsive = new double[2];
        double dq = ((robot.x - obs.x)*(robot.x - obs.x) + (robot.y - obs.y)*(robot.y - obs.y)) ;
        double repulsiveForce = KR * (1/dq);
        double repulsiveAngle = Math.atan((robot.y-obs.x)/(robot.x-obs.x));
        repulsive[0] = repulsiveForce;
        repulsive[1] = repulsiveAngle;
        return repulsive;
    }
    public double[] calculateAttractive(){
        double[] attractive = new double [2];
        double toGoalDist = (robot.x - robot.goalX)*(robot.x - robot.goalX) + (robot.y - robot.goalY)*(robot.y - robot.goalY);
        double attractiveForce = 0.5*KA * toGoalDist;
        double attractiveAngle = Math.atan((robot.y-robot.goalY)/(robot.x-robot.goalX));
        attractive[0] = attractiveForce;
        attractive[1] = attractiveAngle;
        return attractive;

    }
    //TODO: BORDER YOK
    //TODO: Uçuyor gidiyor

    public double calculatePotentials(){
        //InMethod Variables
        double timeStep = 0;
        double forceActingX;
        double forceActingY;
        double accelerationX;
        double accelerationY;
        double displacementX = 0;
        double displacementY = 0;
        while (Math.abs(robot.x - robot.goalX) > 1 && Math.abs(robot.y - robot.goalY)>1){
            forceActingX = (calculateAttractive()[0]*Math.cos(calculateAttractive()[1]))
                    -(calculateRepulsive()[0]*Math.cos(calculateRepulsive()[1]));
            forceActingY = (calculateAttractive()[0]*Math.sin(calculateAttractive()[1]))
                    -(calculateRepulsive()[0]*Math.sin(calculateRepulsive()[1]));

            accelerationX = forceActingX/robot.mass;
            accelerationY = forceActingY/robot.mass;
            setRobotVelocity(robot.velocityX+accelerationX*timeStep,
                    robot.velocityY+accelerationY*timeStep);
            displacementX = robot.velocityX*timeStep;
            displacementY = robot.velocityY*timeStep;
            timeStep = timeStep + 0.1;
            setRobotCoordinates(robot.x-displacementX, robot.y-displacementY);
            System.out.println("Robot X : " + robot.x);
            System.out.println("Robot Y : " + robot.y);
        }
        return displacementX;
    }

}
