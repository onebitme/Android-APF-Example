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
    public float goalX;
    public float goalY;
    Float object = goalX;

    public PathView(Context context) {
        super(context);
        paint = new Paint();
        paint.setStrokeWidth(6f);
        paint.setColor(Color.GREEN);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStrokeWidth(6f);
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (arrayToDraw != null && object != null ) {

            canvas.drawLines(arrayToDraw, paint);
            canvas.drawCircle(goalX,goalY, 20f,paint);
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
