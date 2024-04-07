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
}
