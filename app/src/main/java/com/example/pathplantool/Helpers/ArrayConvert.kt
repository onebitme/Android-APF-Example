package com.example.pathplantool.Helpers

fun makeAPFPathArray(previousArray: FloatArray, coordinateX: Float, coordinateY: Float): FloatArray {

    val newArray = previousArray.copyOf(previousArray.size + 2)
    /*if (newArray.size == 4){
        newArray[0]=coordinateX
        newArray[1]=coordinateY
        newArray[2]=coordinateX
        newArray[3]=coordinateY
    }*/
    newArray[newArray.size-2] = coordinateX
    newArray[newArray.size-1] = coordinateY

    return newArray
}