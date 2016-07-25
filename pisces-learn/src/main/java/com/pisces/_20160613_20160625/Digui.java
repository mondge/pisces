package com.pisces._20160613_20160625;

/**
 * Created by jun.xu on 16/6/20.
 */
public class Digui {

    public static int  add(int i){
        int sum=0;
        if(i==0){
            System.out.println("before i=1,"+i);
            i=1;
            System.out.println("after i=1,"+i);
        }else{
            System.out.println("before i="+i);
            sum=i+ add(i-1);
            System.out.println("after i="+i);
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(add(5));
    }
}
