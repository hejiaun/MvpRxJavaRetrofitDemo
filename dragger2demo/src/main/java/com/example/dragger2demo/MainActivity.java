package com.example.dragger2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dragger2demo.commponent.DaggerSimpleComponent;
import com.example.dragger2demo.entity.Student;
import com.example.dragger2demo.module.SimpleModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Inject @Named("aa")
    Student student;
//    @Inject
//    Teacher teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerSimpleComponent
                .builder()
                .simpleModule(new SimpleModule(this))
                .build()
                .inject(this);
//        DaggerSimpleComponent.
        Log.d("ddd", student.b + "");
//        Log.d("ddd", student.toString());

//        Log.d("ddd", teacher.toString());

    }
}
