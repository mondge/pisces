package com.pisces._20160613_20160625;

import com.google.common.base.Ticker;
import com.google.common.cache.*;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.pisces._20160530_20160612.collection.HashMap;
import com.pisces._20160613_20160625.dto.Student;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by jun.xu on 16/6/13.
 */
public class GuavaCache {
    LoadingCache<Integer, Student> STUDENT_CACHE = CacheBuilder
            .newBuilder().recordStats().ticker(new Ticker() {
                @Override
                public long read() {
                    return 0;
                }
            })
            .removalListener(new RemovalListener<Integer, Student>() {
                @Override
                public void onRemoval(RemovalNotification<Integer, Student> notification) {
                    System.out.println(notification.getValue() + "remove");
                }
            })
            .expireAfterWrite(10, TimeUnit.SECONDS).expireAfterAccess(10,TimeUnit.MINUTES)
            .weigher(new Weigher<Integer, Student>() {
                @Override
                public int weigh(Integer key, Student value) {
                    return value.getId();
                }
            })
            .maximumWeight(20)
            .build(new CacheLoader<Integer, Student>() {
                @Override
                public Student load(Integer key) throws Exception {
                    return getStudent(key);
                }
            });

    LoadingCache<Integer,Student> STUDENT_CACHE_ALL=CacheBuilder
            .newBuilder().maximumSize(10).expireAfterWrite(10,TimeUnit.SECONDS)
            .build(
                new CacheLoader<Integer, Student>() {
                    @Override
                    public Student load(Integer key) throws Exception {
                        return getStudent(key);
                    }
                    @Override
                    public Map<Integer, Student> loadAll(Iterable<? extends Integer> keys) throws Exception {
                        return getStudents(keys);
                    }

                    @Override
                    public ListenableFuture<Student> reload(Integer key, Student oldValue) throws Exception {
                        ListenableFutureTask<Student> task=ListenableFutureTask.create(new Callable<Student>() {
                            @Override
                            public Student call() throws Exception {
                                return null;
                            }
                        });
                        return Futures.immediateFuture(oldValue);
                    }
                }
            );


    private Student getStudent(Integer key) {
        Student student = new Student();
        student.setId(key);
        student.setName("jun.xu" + key);
        student.setAge(key + 15);
        student.setSex("男");
        student.setStuClass("一班");
        return student;
    }

    private  Map<Integer, Student>  getStudents(Iterable<? extends Integer> keys) {
        Map<Integer, Student> maps=new HashMap<>();
        for(Integer key:keys) {
            Student student = new Student();
            student.setId(key);
            student.setName("jun.xu" + key);
            student.setAge(key + 15);
            student.setSex("男");
            student.setStuClass("一班");
            maps.put(key,student);
        }
        return maps;
    }


}
