package com.example.cpu11341_local.userviewtest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.icu.text.DecimalFormat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by CPU11341-local on 8/2/2017.
 */

public class CustomBarChart extends View {
    Paint mPaint;
    TextPaint mTextPaint;
    ArrayList<String> arrayListColName = new ArrayList<String>();
    ArrayList<String> arrayListColNameColor = new ArrayList<String>();
    ArrayList<Integer> arrayListViewTime = new ArrayList<Integer>();
    ArrayList<Integer> arrayListValue = new ArrayList<Integer>();
    int nextHeight;
    int TopCol = 600;
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

    public void setColValue(ArrayList<String> arrayListColName, ArrayList<String> arrayListColNameColor, ArrayList<Integer> arrayListViewTime){
        this.arrayListColName.clear();
        this.arrayListColName = arrayListColName;
        this.arrayListColNameColor.clear();
        this.arrayListColNameColor = arrayListColNameColor;
        this.arrayListViewTime.clear();
        this.arrayListViewTime = arrayListViewTime;
        int maxTime = Collections.max(arrayListViewTime);
        nextHeight = maxTime;
        while (nextHeight % 5 != 0){
            nextHeight++;
        }
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        final int width = 80;
        final int height = 500;

        int left = leftValue();
        final int top = 100;

        int i = 0;

        for (String str : arrayListColName){

            int textLeft = left + 40;
            //Vẽ cột rỗng
            mPaint.setColor(Color.parseColor("#e5f6fd"));
            canvas.drawRect(left, top, left + width, top + height, mPaint);
            //vẽ tên cột
            Rect bounds = new Rect();
            mTextPaint.setColor(Color.parseColor("#000000"));
            mTextPaint.getTextBounds(str, 0, str.length(), bounds);
            int textWidth = bounds.width();
            canvas.drawText(str, textLeft - textWidth/2, top + height + 50, mTextPaint);

            i++;
            left += 150;
        }

        left = leftValue();
        i = 0;
        for (int viewTime : arrayListViewTime){

            //vẽ cột có giá trị
            int textLeft = left + 40;
            int colValue = Math.round(viewTime * height / nextHeight);
            mPaint.setColor(Color.parseColor(arrayListColNameColor.get(i)));

            if (TopCol > (top + height - colValue)){
                canvas.drawRect(left, TopCol, left + width, top + height, mPaint);
                TopCol--;
                Log.d("TopCol", String.valueOf(TopCol));
            }
            else {
                canvas.drawRect(left, top + height - colValue, left + width, top + height, mPaint);
            }

            //vẽ giá trị của cột
            Rect bounds = new Rect();
            String colValueNumber = String.format("%.1f h", (float)arrayListViewTime.get(i) / 60.0);
            mTextPaint.getTextBounds(colValueNumber, 0, colValueNumber.length(), bounds);
            int textWidth = bounds.width();
            mTextPaint.setColor(Color.parseColor(arrayListColNameColor.get(i)));
            canvas.drawText(colValueNumber, textLeft - textWidth/2, top - 30, mTextPaint);

            i++;
            left += 150;
        }
        invalidate();
    }

    private void initPaint(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#e5f6fd"));
        mPaint.setStrokeWidth(30);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(30);
    }


    private int leftValue(){
        int left = getWidth() - (150+150+150+80);
        return left/2;
    }
}
