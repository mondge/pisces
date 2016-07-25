package com.pisces._20160716_20160729.procducerCustomer;

/**
 * Created by jun.xu on 16/7/17.
 */
public class Buffer {
    int num;
    volatile boolean isFull;

    public Buffer(){
        isFull=false;
    }

    synchronized int get(){
        while(!isFull){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(num+"已经被消费了");
        isFull=false;
        notifyAll();
        return num;
    }

    synchronized  void put(int num){
        while(isFull){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.num=num;
        isFull=true;
        System.out.println(num+"已经被生成");
        notifyAll();
    }
}
