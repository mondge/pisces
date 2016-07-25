package com.pisces._20160613_20160625.dto;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (id != student.id) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (sex != null ? !sex.equals(student.sex) : student.sex != null) return false;
        if (stuClass != null ? !stuClass.equals(student.stuClass) : student.stuClass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (stuClass != null ? stuClass.hashCode() : 0);
        return result;
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
