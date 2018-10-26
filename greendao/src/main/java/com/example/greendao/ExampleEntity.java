package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * ProjectName:MvpRxJavaRetrofitDemo
 * Author: HeJiaJun
 * Date:2018/10/25 16:43
 * Description:
 */
@Entity
public class ExampleEntity {
    @Id
    public long id;
    @NotNull
    private String name;
    @Generated(hash = 1126605431)
    public ExampleEntity(long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 432642163)
    public ExampleEntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
