package com.example.administrator.add_stu;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String age;
    private String major;
    public Student(){


    }
    public Student(String name, String age, String major) {
        this.name=name;
        this.age=age;
        this.major=major;
    }
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}