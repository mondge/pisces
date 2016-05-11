package com.pisces.collect.set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jun.xu on 16/5/11.
 */
public class MultiSet {

    public void multisetCount() {
        List<String> wordList = Lists.newArrayList("a", "b", "c", "d", "e", "f", "a", "b", "c", "d", "e", "f", "a", "b", "c", "d", "e", "f", "a", "b", "c", "d", "e", "f");
        Multiset<String> multiset= HashMultiset.create();
        multiset.addAll(wordList);
        for(String key:multiset.elementSet()){
            System.out.println("key:"+key+",count:"+multiset.count(key));
        }
    }
}
