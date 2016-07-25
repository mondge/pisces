package com.pisces._20160716_20160729.procducerCustomer;

/**
 * Created by jun.xu on 16/7/17.
 */
public class Customer implements Runnable{
    private Buffer bf;
    public Customer(Buffer bf){
        this.bf=bf;
    }

    @Override
    public void run() {
        while (true){
            bf.get();
        }
    }

}
