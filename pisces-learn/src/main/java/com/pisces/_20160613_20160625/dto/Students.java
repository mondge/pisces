package com.pisces._20160613_20160625.dto;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by jun.xu on 16/5/30.
 */
public class Students {

    public static List<Student> getStudents(int i){
        List<Student> stus= Lists.newArrayList();
        for(int j=0;j<i;j++){
            Student student=new Student();
            student.setName("jun.xu"+j);
            student.setSex(j % 2 == 0 ? "男" : "女");
            student.setAge(10 + j);
            student.setId(j);
            student.setStuClass(j % 2 == 0 ? "一班" : "二班");
            stus.add(student);
        }
        return stus;
    }
}
