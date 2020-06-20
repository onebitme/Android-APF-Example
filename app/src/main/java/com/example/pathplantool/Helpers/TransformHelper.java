package com.example.pathplantool.Helpers;

public class TransformHelper {


    /*        posArray[0] =  -360f+((messageArray[5]-65536f)/10f)*11f; // Her Bir metre 11 Pixeldir
        System.out.println("X Coordinate:" + ((messageArray[5]-65536f)/10f) + "Pos Array Truck Pixel X: " + posArray[0]);
        posArray[1] =  460f+26f-((messageArray[6]-65536f)/10f)*11f; // Her Bir Metre 11 pixeldir
        System.out.println("Y Coordinate :" + ((messageArray[6]-65536f)/10f) + "Pos Array Truck Pixel Y: " + posArray[1]);
        posArray[2] = 90f-(((((messageArray[7])-65536f)/1000f)%(2f*pi))*180f/pi);
        System.out.println("Pos Array Truck Angle :" + posArray[2]);
        posArray[3] = 90f-(((((messageArray[8])-65536f)/10f)%(2f*pi))*180f/pi);
        System.out.println("Pos Array Trailer Angle" + posArray[3]);
     */

    public float[] trailerPos(float truckX, float truckY, float truckTheta, float trailerTheta ){


        float trailerPos[] = new float[3];

        float truckKingpin = 60f; // Static value for kinppin distance
        float trailer2Kingpin = 273f/2f; // Static distance for trailer middle point to kingpin
        float cosTruck = ((float)Math.cos(Math.toRadians(90-truckTheta)));
        float sinTruck = ((float)Math.sin(Math.toRadians(90-truckTheta)));

        float kingpinX =  truckX-cosTruck*truckKingpin;
        float kingpinY =  truckY+sinTruck*truckKingpin;

        float cosTrailer = ((float)Math.cos(Math.toRadians(90 - trailerTheta)));
        float sinTrailer = ((float)Math.sin(Math.toRadians(90 - trailerTheta)));



        //x Position
        trailerPos[0] = kingpinX-cosTrailer*trailer2Kingpin;
        //Y Position
        trailerPos[1] = kingpinY+sinTrailer*trailer2Kingpin-80f;

        System.out.println("Esozen// Transform Debug End");
        System.out.println("TruckX= "+ truckX + "// Kingpin x=" + kingpinX);
        System.out.println("TruckY= "+ truckY + "// Kingpin Y=" + kingpinY);
        System.out.println("TrailerX= " + trailerPos[0]);
        System.out.println("TrailerY= " + trailerPos[1]);
        System.out.println("TruckTheta = " + truckTheta + "// CosTruckTheta= " + cosTruck);
        System.out.println("TruckTheta = " + truckTheta + "// SinTruckTheta= " + sinTruck);

        //trailer theta(relative to global)
        //trailerPos[2] = (float) Math.toRadians(trailerTheta);
        trailerPos[2] = trailerTheta;


        System.out.println("Esozen// Transform Debug End");
        return trailerPos;
    }

}
