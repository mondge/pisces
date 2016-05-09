package com.pisces.collect.set;

import org.junit.Test;

/**
 * Created by jun.xu on 16/5/9.
 */
public class ImmutableTest {
    Immutable immutable=new Immutable();
    @Test
    public void testPrintImmutableSetOf(){
        immutable.printImmutableSetOf();
    }
    @Test
    public void testPrintImmutableSetCopyOf(){
        immutable.printImmutableSetCopyOf();
    }
    @Test
    public void testPrintImmutableSetBuild(){
        immutable.printImmutableSetBuild();
    }
    @Test
    public void testPrintImmutableSortedSetBuild(){
        immutable.printImmutableSortedSetCopyOf();
    }
}
