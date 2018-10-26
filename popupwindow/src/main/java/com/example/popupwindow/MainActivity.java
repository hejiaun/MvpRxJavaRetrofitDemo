package com.example.popupwindow;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow();
            }
        });
    }

    /**
     * 显示弹性窗口
     */
    public void showPopupWindow() {//一定要设置宽高
        View view = View.inflate(this, R.layout.popupwindow_demo, null);
        final PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //点击窗口外
        popupWindow.setOutsideTouchable(true);
//        //设置点击外面小时对话框
//        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                popupWindow.dismiss();
//            }
//        });
//        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_OUTSIDE:
//                        popupWindow.dismiss();
//                        break;
//                }
//                return true;
//            }
//        });
        popupWindow.showAsDropDown(button, 0, 0);
    }
}
