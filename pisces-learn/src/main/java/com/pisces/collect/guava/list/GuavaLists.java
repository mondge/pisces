package com.pisces.collect.guava.list;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jun.xu on 16/5/26.
 */
public class GuavaLists {
    Function<Student,String> function=new Function<Student, String>() {
        @Override
        public String apply(Student input) {
            return input.getName();
        }
    };
    public void testConcat(){
        Iterable<Integer> concatenated= Iterables.concat(Ints.asList(1,2,3),Ints.asList(4,5,6));
        Integer lastAdded=Iterables.getLast(concatenated);
        Iterable<Integer> only= Ints.asList(1);
        Integer theElement=Iterables.getOnlyElement(only);
        System.out.println(lastAdded);
        System.out.println(theElement);
    }

    public void testIntersection(){
        Set<Student> studentSet= ImmutableSet.of(new Student(18,"xujun"),new Student(20,"yuchunhui"));
        Set<Student> studentSet2= ImmutableSet.of(new Student(28,"xujun2"),new Student(20,"yuchunhui"));
        Sets.SetView<Student> intersection=Sets.intersection(studentSet,studentSet2);
        System.out.println(intersection.immutableCopy().toString());
    }

    public void getStudent(){

        List<String> names= Lists.transform(ImmutableList.of(new Student(18, "xujun"), new Student(20, "yuchunhui")), function);
        System.out.println(names);
    }

    public void getStudentMap(){
        Map<String,Student> studentMap=Maps.uniqueIndex(ImmutableList.of(new Student(18, "xujun"), new Student(20, "yuchunhui")),function);
        System.out.println(studentMap);
    }

    public void getStr(){
        List<String> origin = Lists.newArrayList("A", "B", "C", "D");
        String s= Joiner.on(",").skipNulls().join(origin);
        System.out.println(s);

        String param = "A=a&B=b&C=c&D=d";
        Map<String,String> strMap= Splitter.on("&").withKeyValueSeparator("=").split(param);
        System.out.println(strMap);
     }

    class Student{
        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        String name;

        int age;

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }



}


