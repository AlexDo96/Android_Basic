package com.example.administrator.demo1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 10/28/2016.
 */
public class MultiTouch extends View {

    Paint paint=new Paint();
    ArrayList<Float> x=new ArrayList<Float>(); ArrayList<Float> y=new ArrayList<Float>();
    ArrayList<Boolean> istouch=new ArrayList<Boolean>();

    public MultiTouch(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        for(int i=0;i<x.size();i++)
            if(istouch.get(i)==true)
                canvas.drawCircle(x.get(i), y.get(i),50f, paint);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        int index = MotionEventCompat.getActionIndex(event);
        switch(action)
        {
            case MotionEvent.ACTION_DOWN:
                istouch.add(true);
                x.add(event.getX(index));
                y.add(event.getY(index));
                break;
            case MotionEvent.ACTION_POINTER_DOWN: //ngon dau tien nhan xuong
                istouch.add(true);
                x.add(event.getX(index));
                y.add(event.getY(index));
                break;
            case MotionEvent.ACTION_MOVE:
                int count=event.getPointerCount();
                for(int i=0;i<count;i++)
                {
                    index=i;
                    x.set(index,event.getX(index));
                    y.set(index,event.getY(index));
                }
                break;
            case MotionEvent.ACTION_UP:
                istouch.remove(index);
                x.remove(index);
                y.remove(index);
                break;
            case MotionEvent.ACTION_POINTER_UP: //ngon cuoi cung nha ra
                istouch.remove(index);
                x.remove(index);
                y.remove(index);
                break;
        }

        invalidate();
        return true;//super.onTouchEvent(event);
    }
}
