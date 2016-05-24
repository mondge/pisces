package com.pisces.collect.predicates;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by jun.xu on 16/5/24.
 */
public class GuavaPredicate {
    private static Predicate<Integer> predicate=new Predicate<Integer>() {
        @Override
        public boolean apply(Integer input) {
            return input>=1000;
        }
    };

    private static Predicate<Integer> precidate2=new Predicate<Integer>() {
        @Override
        public boolean apply(Integer input) {
            return input<=5000;
        }
    };

    private static Predicate<Integer> predicate3= Predicates.and(predicate, precidate2);

    public void predicate(){
        List<Integer> ints= Lists.newArrayList(500, 1000, 2000, 3000, 4000, 5000, 6000);
        List<Integer> filterInts=Lists.newArrayList(Iterables.filter(ints, predicate3));
        System.out.println(filterInts);
    }
}
