package com.example.pathplantool.Helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;


public class PathView extends View {
    private Paint paint;
    //private Repository repository = Repository.getInstance();
    private float[] arrayToDraw;
    private float radius=100;


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

        System.out.println("ocul - ondraw yapıldı");
        //drawPath(canvas, repository.getPathArray());
        //canvas.drawCircle(100,100,radius,paint);
        //canvas.drawLine(200.0f,200.0f,radius*10.0f,radius*12.0f,paint);
        //canvas.save();
        //canvas.rotate(0);
        //canvas.drawLines(PathCSVKt.makeFloatArray(),paint);
        //arrayToDraw = repository.getPathArray();
        System.out.println("esoze - repodan array aldı");
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
        //arrayToDraw = repository.getPathArray();
        //radius=repository.getIncomingLongMessage()[8];
        //System.out.println("ocul- path update yapıldı radius:  "+repository.getIncomingLongMessage()[8]);
        postInvalidate();
    }
}
