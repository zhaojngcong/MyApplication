package com.bawei.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 赵静聪 on 2017/11/30.
 */

public class Myview extends View{

    public Myview(Context context) {
        super(context);
    }

    public Myview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


//定位
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
//测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
//绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paintred=new Paint();
        Paint paintblue=new Paint();
        paintblue.setTextSize(50);
        paintblue.setColor(Color.BLUE);
        paintblue.setStyle(Paint.Style.STROKE);
        paintred.setColor(Color.RED);
       /* canvas.drawText("画圆",20,50,paintblue);
        canvas.drawCircle(50,100,50,paintred);
        canvas.drawCircle(150,100,50,paintred);
        canvas.drawCircle(250,100,50,paintred);
        canvas.drawCircle(350,100,50,paintred);
        canvas.drawText("画矩形",20,200,paintblue);
        //RectF r=new RectF(0,200,100,400);
        canvas.drawRect(new RectF(0,200,100,400),paintred);
        canvas.drawRect(new RectF(150,200,250,400),paintred);
        canvas.drawRect(new RectF(260,200,360,400),paintred);
        canvas.drawRect(new RectF(370,200,480,400),paintred);*/
        Paint paintblack=new Paint();
        Paint p1=new Paint();
        paintblack.setColor(Color.BLACK);// 设置绿色
        //canvas.drawLine(60, 40, 100, 40, p);// 画线
        //canvas.drawLine(110, 40, 190, 80, p);// 斜线
        //画笑脸弧线
        p1.setStyle(Paint.Style.STROKE);//设置空心
        canvas.drawCircle(400,400,300,p1);//画一个空心圆
        RectF r=new RectF(150,250,350,300);
        canvas.drawArc(r,180,180,true,paintred);
        r.set(450,250,650,300);
        canvas.drawArc(r,180,180,true,paintred);
        r.set(200,300,600,650);
        canvas.drawArc(r,0,180,false,paintblue);


        RectF oval1=new RectF(150,20,180,40);

        canvas.drawArc(oval1, 180, 180, true, paintblack);//小弧形
        oval1.set(190, 20, 220, 40);
        canvas.drawArc(oval1, 180, 180, true, paintblack);//小弧形
        oval1.set(160, 30, 210, 60);
        canvas.drawArc(oval1, 0, 150, true, paintblack);//小弧形

    }
}
