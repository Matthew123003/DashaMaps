package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMapTest {
    //Need to write tests
    @Test
    public void mapPutTest1(){
        DashaMapOne dm1 = new DashaMapOne();

        dm1.put("help", 1);
        boolean assertMapContains = dm1.isEmpty();

        Assert.assertFalse(assertMapContains);
    }

    @Test
    public void mapPutTest2(){
        DashaMapTwo dm2 = new DashaMapTwo();

        dm2.put("help", 1);
        boolean assertMapContains = dm2.isEmpty();

        Assert.assertFalse(assertMapContains);
    }

    @Test
    public void mapPutTest3(){
        DashaMapThree dm3 = new DashaMapThree();

        dm3.put("help", 1);
        boolean assertMapContains = dm3.isEmpty();

        Assert.assertFalse(assertMapContains);
    }
}
