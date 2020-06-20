package com.example.trustvehicle.Helpers

private var coordinatePath = "95.41\t16.64\t95.4\t21.59\t95.15\t26.39\t94.6\t31.2\t93.64\t36.78\t92.43\t44.43\t92.32\t49.52\t92.84\t52.72\t94.11\t56.4\t96.8\t60.53\t60.86\t48.36\t65.17\t48.45\t69.47\t48.68\t73.78\t49.05\t78.09\t49.56\t82.39\t50.23\t86.7\t51.29\t91.01\t53.67\t95.31\t57.03\t99.62\t61.92\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0"


fun makeFloatArray(): FloatArray {

    var floatCoordinatesString = coordinatePath.replace("\t","f,")
    var floatCoordinatesStringArray = floatCoordinatesString.split(",").toTypedArray();
    var j=0;
    var floatCoordinatesXY = FloatArray(floatCoordinatesStringArray.size)
    for (key in floatCoordinatesStringArray){
        if (j % 2 == 0){
            floatCoordinatesXY[j] = key.toFloat()*10f//-200f
        }
        else if (j%2==1){
            floatCoordinatesXY[j] = 900f- key.toFloat()*10f//-200f
        }
        j=j+1

    }

    return floatCoordinatesXY
}