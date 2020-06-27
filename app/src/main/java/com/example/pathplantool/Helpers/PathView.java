package com.example.pathplantool.Helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import com.example.trustvehicle.Helpers.PathCSVKt;


public class PathView extends View {
    private Paint paint;
    //private Repository repository = Repository.getInstance();
    private float[] arrayToDraw;
    private float radius=100;

    private PathCSVKt csvKt;


    public PathView(Context context) {
        super(context);
        paint = new Paint();
        paint.setStrokeWidth(10f);
        paint.setColor(Color.BLUE);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStrokeWidth(10f);
        paint.setColor(Color.BLUE);
    }

    public void drawPath(Canvas canvas, float[] coordinateArray) {
        if (arrayToDraw != null) {
            canvas.drawLines(arrayToDraw, paint);
            System.out.println("bir path çizildi");
        }
    }

    public float[] convertLongArrayToFloatArray(long[] longArray) {
        float[] floatArray = new float[longArray.length];
        for (int i = 0; i < longArray.length; i++) {
            floatArray[i] = longArray[i];
        }
        return floatArray;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (arrayToDraw != null) {
            System.out.println("esozen: path ilk elemanı" +"X: " + arrayToDraw[0] + " Y: "+arrayToDraw[1]);
            canvas.drawLines(arrayToDraw, paint);
            System.out.println("bir path çizildi");
        }
        else{
            System.out.println("arrayToDraw = Null");
        }

    }



    public void updatePath() {

        arrayToDraw = csvKt.makeFloatArray();
        postInvalidate();
    }
}
