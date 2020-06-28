package com.example.pathplantool;

public class PotentialField {

    //Repulsive Cost
    double KR = 1;
    //Attractive Cost
    double KA = 4;

    //Where everything is calculated
    public double[] calculateRepulsive(double robotX, double robotY, double obsX, double obsY){
        double[] repulsive = new double[2];
        double dq = ((robotX - obsX)*(robotX - obsX) + (robotY - obsX)*(robotY - obsY)) ;
        double repulsiveForce = KR * (1/dq);
        double repulsiveAngle = Math.atan((robotY-obsX)/(robotX-obsX));
        repulsive[0] = repulsiveForce;
        repulsive[1] = repulsiveAngle;
        return repulsive;
    }
    public double[] calculateAttractive(double robotX, double robotY, double goalX, double goalY){
        double[] attractive = new double [2];
        double toGoalDist = (robotX - goalX)*(robotX - goalX) + (robotY - goalY)*(robotY - goalY);
        double attractiveForce = 0.5*KA * toGoalDist;
        double attractiveAngle = Math.atan((robotY-goalY)/(robotY-goalX));
        attractive[0] = attractiveForce;
        attractive[1] = attractiveAngle;
        return attractive;

    }
    //TODO: BORDER YOK
    //TODO: Uçuyor gidiyor

    public double[] calculatePotentials(double robotX, double robotY, double robotMass, double goalX, double goalY, double obsX, double obsY ,double timeStep){
        //InMethod Variables

        double[] positionAndVelocity = new double[4];

        double forceActingX = 0;
        double forceActingY = 0;
        double accelerationX = 0;
        double accelerationY = 0;
        double displacementX = 0;
        double displacementY = 0;
        double robotVelocityX = 0;
        double robotVelocityY = 0;


        forceActingX = (calculateAttractive(robotX, robotY, goalX, goalY)[0] * Math.cos(calculateAttractive(robotX, robotY, goalX, goalY)[1]))
                - (calculateRepulsive(robotX, robotY, obsX, obsY)[0] * Math.cos(calculateRepulsive(robotX, robotY, obsX, obsY)[1]));
        forceActingY = (calculateAttractive(robotX, robotY, goalX, goalY)[0] * Math.sin(calculateAttractive(robotX, robotY, goalX, goalY)[1]))
                - (calculateRepulsive(robotX, robotY, obsX, obsY)[0] * Math.sin(calculateRepulsive(robotX, robotY, obsX, obsY)[1]));

        accelerationX = forceActingX / robotMass;
        accelerationY = forceActingY / robotMass;
        robotVelocityX = robotVelocityX + accelerationX;
        robotVelocityY= robotVelocityY + accelerationY;
        displacementX = robotVelocityX;
        displacementY = robotVelocityY;

        positionAndVelocity[0] = robotX-displacementX;
        positionAndVelocity[1] = robotY-displacementY;
        positionAndVelocity[2] = robotVelocityX;
        positionAndVelocity[3] = robotVelocityY;

        return positionAndVelocity;
    }

}
