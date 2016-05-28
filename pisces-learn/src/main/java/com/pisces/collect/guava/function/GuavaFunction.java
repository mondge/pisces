package com.pisces.collect.guava.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jun.xu on 16/5/19.
 */
public class GuavaFunction {

    public static Function<Date, String> function = new Function<Date, String>() {
        @Override
        public String apply(Date input) {
            return new SimpleDateFormat("yyyy/MM/dd").format(input);
        }
    };

    public static Function<String,String> toUperFunction=new Function<String, String>() {
        @Override
        public String apply(String input) {
            return input.toUpperCase();
        }
    };

    public void lookUp(){
        Map<String,String> map=new HashMap<String,String>();
        map.put("a1","1a");
        map.put("a2","2a");
        map.put("a3","3a");
        map.put("a4","4a");
        map.put("a5","5a");
        map.put("a6","6a");
        map.put("a7","7a");
        map.put("a8","8a");
        map.put("a9","9a");
        Function<String,String> lookUp= Functions.forMap(map);
        Function composeFunction=Functions.compose(toUperFunction,lookUp);
        System.out.println(composeFunction.apply("a9"));
    }

    public void transform(){
        List<Person> list=Lists.newArrayList(new Person(12,"jun.xu",0),new Person(13,"jing.xu",1),new Person(12,"chunhui.yu",1));
        List<Student> students=Lists.transform(list, new Function<Person,Student>() {
            @Override
            public Student apply(Person input) {
                Student student=new Student();
                student.setAge("年龄:"+input.age);
                student.setSex("性别:"+input.sex);
                student.setName("姓名:"+input.name);
                return student;
            }
        });
        System.out.println(students);

    }

    public class Person{
        String name;
        int age;
        int sex;

        public Person(int age, String name, int sex) {
            this.age = age;
            this.name = name;
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", sex=" + sex +
                    '}';
        }
    }

    public class Student{
        String name;
        String age;
        String sex;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
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

        @Override
        public String toString() {
            return "Student{" +
                    "age='" + age + '\'' +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
}