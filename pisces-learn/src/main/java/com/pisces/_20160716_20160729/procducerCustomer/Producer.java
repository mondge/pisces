package com.pisces._20160716_20160729.procducerCustomer;

/**
 * Created by jun.xu on 16/7/17.
 */
public class Producer implements Runnable{
    private Buffer bf;
    private int i;
    public Producer(Buffer bf){
        this.bf=bf;
    }

    @Override
    public void run() {
        while (true){
            i++;
            bf.put(i);
        }
    }
}
