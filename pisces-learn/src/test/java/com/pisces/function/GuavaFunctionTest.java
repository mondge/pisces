package com.pisces.function;

import com.pisces.collect.function.GuavaFunction;
import org.junit.Test;

import java.util.Date;

/**
 * Created by jun.xu on 16/5/19.
 */
public class GuavaFunctionTest {
    GuavaFunction guavaFunction = new GuavaFunction();

    @Test
    public void dateFormatTest() {
        System.out.println(GuavaFunction.function.apply(new Date()));
    }

    @Test
    public void lookUpTest() {
        guavaFunction.lookUp();
    }
}

