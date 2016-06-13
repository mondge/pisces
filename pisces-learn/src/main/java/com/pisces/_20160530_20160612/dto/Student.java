package com.pisces._20160530_20160612.dto;

/**
 * Created by jun.xu on 16/5/30.
 */
public class Student {
    private int id;

    private String name;

    private int age;

    private String sex;

    private String stuClass;

    public Student() {
    }

    public Student(int id) {
        this.id = id;
        this.name="jun.xu"+id;
        this.age=8;
        this.sex="男";
        this.stuClass="一班";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", stuClass='" + stuClass + '\'' +
                '}';
    }
}
