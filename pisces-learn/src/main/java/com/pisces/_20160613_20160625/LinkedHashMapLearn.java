package com.pisces._20160613_20160625;

/**
 * Created by jun.xu on 16/6/18.
 */
public class LinkedHashMapLearn {


    public void test1(){
        LinkedHashMap m=new LinkedHashMap(10,0.75f,true);
        m.put(1,"a");
        m.put(2,"b");
        m.put(3,"c");
        m.put(4,"d");
        m.get(4);
        m.get(3);

    }
}
