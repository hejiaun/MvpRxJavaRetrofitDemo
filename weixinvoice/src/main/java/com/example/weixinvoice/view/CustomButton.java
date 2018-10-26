package com.example.weixinvoice.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomButton extends android.support.v7.widget.AppCompatButton {


    public CustomButton(Context context) {
        this(context,null);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //开始录音
                return false;
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:

                break;
        }

        return super.onTouchEvent(event);
    }
}

