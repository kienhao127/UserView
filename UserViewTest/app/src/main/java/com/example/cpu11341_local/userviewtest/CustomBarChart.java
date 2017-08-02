package com.example.cpu11341_local.userviewtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by CPU11341-local on 8/2/2017.
 */

public class CustomBarChart extends View {
    Paint mPaint;
    public CustomBarChart(Context context) {
        this(context, null);
    }

    public CustomBarChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomBarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw component in here
        float width = 100;
        float height = 200;

        float left = (getWidth() - width) / 2.0f;
        float top = (getHeight() - height) / 2.0f;
        canvas.drawRect(left, top, left + width, top + height, mPaint);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#e5f6fd"));
        mPaint.setStrokeWidth(30);
    }
}
