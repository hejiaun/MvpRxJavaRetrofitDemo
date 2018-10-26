package com.example.dragger2demo.commponent;

import com.example.dragger2demo.MainActivity;
import com.example.dragger2demo.module.SimpleModule;

import dagger.Component;

/**
 * ProjectName:MvpRxJavaRetrofitDemo
 * Author: HeJiaJun
 * Date:2018/10/11 16:04
 * Description:
 */
@Component(modules = SimpleModule.class)
public interface SimpleComponent {
    void inject(MainActivity activity);
}
