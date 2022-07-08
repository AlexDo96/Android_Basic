package com.example.administrator.demo1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 10/28/2016.
 */
public class SingleTouch extends View {

    Paint paint=new Paint();
    Path path=new Path();
    public SingleTouch(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setAntiAlias(true);//khu rang cua
        paint.setStrokeWidth(6f);//do day
        paint.setColor(Color.RED);//gan mau
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawCircle(250,250,150,p);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                break;
        }

        invalidate();
        return true;//super.onTouchEvent(event);
    }
}
