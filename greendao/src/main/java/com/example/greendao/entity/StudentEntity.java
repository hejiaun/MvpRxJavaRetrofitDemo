package com.example.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * ProjectName:MvpRxJavaRetrofitDemo
 * Author: HeJiaJun
 * Date:2018/10/26 13:37
 * Description:
 */
@Entity
public class StudentEntity {
    @Id
    public Long id;
    @NotNull
    @Property
    public String userName;
    @Property
    public int age;
    @Generated(hash = 2044564539)
    public StudentEntity(Long id, @NotNull String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    @Generated(hash = 634333355)
    public StudentEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
