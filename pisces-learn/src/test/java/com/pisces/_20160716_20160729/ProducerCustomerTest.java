package com.pisces._20160716_20160729;

import com.pisces._20160716_20160729.procducerCustomer.Buffer;
import com.pisces._20160716_20160729.procducerCustomer.Customer;
import com.pisces._20160716_20160729.procducerCustomer.Producer;
import org.junit.Test;

/**
 * Created by jun.xu on 16/7/17.
 */
public class ProducerCustomerTest {

    @Test
    public void test1(){
        Buffer bf=new Buffer();
        new Thread(new Customer(bf)).start();
        new Thread(new Producer(bf)).start();
        System.out.println("end");
    }
}
