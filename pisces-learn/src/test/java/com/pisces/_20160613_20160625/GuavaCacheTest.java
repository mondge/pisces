package com.pisces._20160613_20160625;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.pisces._20160530_20160612.dto.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by jun.xu on 16/6/13.
 */
public class GuavaCacheTest {
    GuavaCache guavaCache = new GuavaCache();

    @Test
    public void test1() {
        try {
            System.out.println(guavaCache.STUDENT_CACHE.get(1));
            System.out.println(guavaCache.STUDENT_CACHE.get(2));
            System.out.println(guavaCache.STUDENT_CACHE.get(3));
            System.out.println(guavaCache.STUDENT_CACHE.get(4));
            System.out.println(guavaCache.STUDENT_CACHE.get(5));
            System.out.println(guavaCache.STUDENT_CACHE.get(6));
            System.out.println(guavaCache.STUDENT_CACHE.get(7));
            System.out.println(guavaCache.STUDENT_CACHE.get(8));
            System.out.println(guavaCache.STUDENT_CACHE.get(9));
            System.out.println(guavaCache.STUDENT_CACHE.get(10));
            System.out.println(guavaCache.STUDENT_CACHE.get(11));
            System.out.println(guavaCache.STUDENT_CACHE.get(12));
            System.out.println(guavaCache.STUDENT_CACHE.asMap());
            System.out.println(guavaCache.STUDENT_CACHE_ALL.getAll(Lists.newArrayList(30, 21, 22, 23, 24, 25, 26)));
            System.out.println(guavaCache.STUDENT_CACHE_ALL.asMap());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
