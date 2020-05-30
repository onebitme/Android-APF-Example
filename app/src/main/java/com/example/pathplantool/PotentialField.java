package com.example.pathplantool;

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
    public void setRobotVelocity(double velocity){
        robot.velocity = velocity;
    }
    public void setRobotHeading(double heading){
        robot.heading = heading;
    }

    //Repulsive Cost
    double KR = 100;
    //Attractive Cost
    double KA = 5;

    public void initALL(){
        setObstacleCoordinate(100,100);
        setRobotCoordinates(101,101);
        setRobotDiameter(10);
        setRobotGoal(20,20);
        setRobotMass(10);
        setRobotVelocity(0);
        setObstacleHeading(0);
        setRobotHeading(0);
    }

    //Where everything is calculated
    public double calculateRepulsive(){
        double dq = ((robot.x - obs.x)*(robot.x - obs.x) + (robot.y - obs.y)*(robot.y - obs.y)) ;
        double repulsive = KR * (1/dq);
        return repulsive;
    }
    public double calculateAttractive(){
        double toGoal = (robot.x - robot.goalX)*(robot.x - robot.goalX) + (robot.y - robot.goalY)*(robot.y - robot.goalY);
        double attactive = 0.5*KA * toGoal;
        return attactive;

    }
    public double calculatePotentials(){
        //t=0
        //While Xinit & Yinit  == GoalXY
        //Attractive - Repulsive  = F
        // F/m = a
        //Displacement = V0*t + 0.5*a*t^2
        //set Robot X - Y from displacement
        double timeStep = 0;
        double forceActing = 0;
        double acceleration = 0;
        double displacement = 0;
        while (timeStep <= 2){
            forceActing = calculateAttractive() - calculateRepulsive();
            acceleration = forceActing/robot.mass;
            setRobotVelocity(acceleration*timeStep);
            displacement = robot.velocity*timeStep; //+ 0.5*acceleration*timeStep*timeStep;
            timeStep = timeStep+ 0.1;
            setRobotCoordinates(robot.x-displacement, robot.y-displacement);
            System.out.println("Robot X : " + robot.x);
            System.out.println("Robot Acc : " + acceleration);
        }
        return displacement;
    }

}
