package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.view.IMainActivityView;
import com.example.administrator.myapplication.persenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivityView {

    private TextView tv;
    private Button btn;
    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        initData();
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(mainActivityPresenter.getMainActivityOnclickListener());
    }

    private void initData() {
        mainActivityPresenter = new MainActivityPresenter(this);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public TextView getTextView() {
        return tv;
    }
}
