package com.pisces.collect.set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jun.xu on 16/5/9.
 */
public class Immutable {
    public void printImmutableSetOf() {
        ImmutableSet<String> immutableSetOf = ImmutableSet.of("one", "one", "tow", "three", "four");
        System.out.println(immutableSetOf.asList());//minus duplicates
    }

    public void printImmutableSetCopyOf() {
        ImmutableSet<Student> stuImmutableSetCopyOf = ImmutableSet.copyOf(getStudents());
        System.out.println(stuImmutableSetCopyOf.asList());//minus duplicates
    }

    public void printImmutableSetBuild() {
        ImmutableSet<Student> studentImmutableSet = ImmutableSet.<Student>builder().addAll(getStudents()).add(new Student(4,"four",4)).build();
        System.out.println(studentImmutableSet.asList());
    }

    public void printImmutableSortedSetCopyOf(){
        ImmutableSortedSet<Student> stuImmutableSortedSet= ImmutableSortedSet.copyOf(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()>=o2.getAge()?-1:1;
            }
        },getStudents());
        System.out.println(stuImmutableSortedSet.asList());
    }
    private List<Student> getStudents() {
        Student stu1 = new Student();
        stu1.setId(1);
        stu1.setName("one");
        stu1.setAge(1);
        Student stu2 = new Student();
        stu2.setId(2);
        stu2.setName("two");
        stu2.setAge(2);
        Student stu3 = new Student();
        stu3.setId(3);
        stu3.setName("three");
        stu3.setAge(3);
        Student stu4 = new Student();
        stu4.setId(1);
        stu4.setName("one");
        stu4.setAge(1);
        Student stu5 = new Student();
        stu5.setId(2);
        stu5.setName("two");
        stu5.setAge(2);
        Student stu6 = new Student();
        stu6.setId(3);
        stu6.setName("three");
        stu6.setAge(3);
        List<Student> stuList = Lists.newArrayList();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
        stuList.add(stu5);
        stuList.add(stu6);
        return stuList;
    }

    private class Student {
        public Student() {
        }

        public Student( int id, String name,int age) {
            this.age = age;
            this.id = id;
            this.name = name;
        }

        private int id;
        private String name;
        private int age;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (age != student.age) return false;
            if (id != student.id) return false;
            if (name != null ? !name.equals(student.name) : student.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + age;
            return result;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
