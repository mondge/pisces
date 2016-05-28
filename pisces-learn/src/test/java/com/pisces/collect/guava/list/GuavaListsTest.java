package com.pisces.collect.guava.list;

import org.junit.Test;

/**
 * Created by jun.xu on 16/5/26.
 */
public class GuavaListsTest {
    GuavaLists guavaLists=new GuavaLists();
    @Test
    public void testConcat(){
        guavaLists.testConcat();
    }

    @Test
    public void testGetStudent(){
        guavaLists.getStudent();
    }

    @Test
    public void testGetStudentMap(){
        guavaLists.getStudentMap();
    }

    @Test
    public void testGetStr(){
        guavaLists.getStr();
    }
}
