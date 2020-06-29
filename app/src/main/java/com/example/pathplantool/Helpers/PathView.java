package com.example.pathplantool.Helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import com.example.pathplantool.Helpers.PathCSVKt;


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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (arrayToDraw != null) {
            canvas.drawLines(arrayToDraw, paint);
        }
        else{
            System.out.println("arrayToDraw = Null");
        }

    }

    public void updatePath(float[] drawMe) {
        arrayToDraw = drawMe;
        postInvalidate();
    }
}
