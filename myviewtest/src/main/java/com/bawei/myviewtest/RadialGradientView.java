package com.bawei.myviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 赵静聪 on 2017/11/30.
 */

public class RadialGradientView extends View {
    Paint mPaint = null;
    // 环形渐变渲染
    Shader mRadialGradient = null;

    public RadialGradientView(Context context) {
        super(context);
        //1.圆心X坐标2.Y坐标3.半径 4.颜色数组 5.相对位置数组，可为null 6.渲染器平铺模式
        mRadialGradient = new RadialGradient(320, 320, 300, new int[] {
                Color.WHITE, Color.YELLOW, Color.GREEN, Color.RED }, null,
                Shader.TileMode.CLAMP);

        mPaint = new Paint();
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setShader(mRadialGradient);
        mPaint.setAntiAlias(true);
        // 第一个,第二个参数表示圆心坐标
        // 第三个参数表示半径
        canvas.drawCircle(350, 360, 300, mPaint);
    }
}
