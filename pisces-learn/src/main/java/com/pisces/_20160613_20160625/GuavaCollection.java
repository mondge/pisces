package com.pisces._20160613_20160625;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import com.pisces._20160613_20160625.dto.Student;
import com.pisces._20160613_20160625.dto.Students;

import java.util.Map;

/**
 * Created by jun.xu on 16/6/21.
 */
public class GuavaCollection {

    public void test1(){
        ArrayListMultimap<String,Integer> mulimap=ArrayListMultimap.create();
        mulimap.putAll("语文", Ints.asList(2,4,6));
        mulimap.putAll("数学", Ints.asList(4,2,1));
        mulimap.putAll("外语", Ints.asList(2,5,3));
        ArrayListMultimap<Integer,String> inverse= Multimaps.invertFrom(mulimap, ArrayListMultimap.<Integer, String>create());
        System.out.println(inverse);
    }

    public void test2(){
        Map<Integer,Student> mapA= Maps.uniqueIndex(Students.getStudents(10), new Function<Student, Integer>() {
            @Override
            public Integer apply(Student input) {
                return input.getId();
            }
        });
        Map mapB= Maps.uniqueIndex(Students.getStudents(5), new Function<Student, Integer>() {
            @Override
            public Integer apply(Student input) {
                return input.getId();
            }
        });
        MapDifference difference=Maps.difference(mapA, mapB);
        System.out.println(difference.entriesDiffering());
        System.out.println(difference.entriesInCommon());
        System.out.println(difference.entriesOnlyOnLeft());
        System.out.println(difference.entriesOnlyOnRight());

        Map mapC=Maps.filterKeys(mapA, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                if (input > 5) {
                    return true;
                }
                return false;

            }
        });
        mapC.get(6);
    }
}
