package com.example.dragger2demo.module;

import com.example.dragger2demo.MainActivity;
import com.example.dragger2demo.entity.Student;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * ProjectName:MvpRxJavaRetrofitDemo
 * Author: HeJiaJun
 * Date:2018/10/11 16:02
 * Description:
 */
@Module
public class SimpleModule {
    private MainActivity activity;

    public SimpleModule(MainActivity activity) {
        this.activity = activity;
    }

    @Named("aa")
    @Provides
    Student c(int d) {
        return new Student(d);
    }

    @Named("ee")
    @Provides
    Student er(int d) {
        return new Student(d);
    }

//    @Named("aa")
    @Provides
    int e(){
        return 1;
    }

//    @Named("aa")
//    @Provides
//    int ee(){
//        return 1;
//    }

//    @Named("bb")
//    @Provides
//    int d() {
//        return 3;
//    }

//    @Provides
//    Student a() {
//        return new Student();
//    }


//    @Provides
//    Teacher b() {
//        return new Teacher(1);
//    }


}
