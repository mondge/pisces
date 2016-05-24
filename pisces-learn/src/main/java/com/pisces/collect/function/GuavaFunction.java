package com.pisces.collect.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
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
}