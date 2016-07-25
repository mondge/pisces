package com.pisces._20160716_20160729;

import com.pisces._20160716_20160729.kmp.KMP;
import org.junit.Test;

/**
 * Created by jun.xu on 16/7/24.
 */
public class KMPTest {
    KMP kmp=new KMP();

    @Test
    public void kmpTest2(){
        String master="efsdfsdfababcabca";
        String matchStr="ababcabca";
        System.out.println(kmp.contains(master.toCharArray(),matchStr.toCharArray()));
    }
}
