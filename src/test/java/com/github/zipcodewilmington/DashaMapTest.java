package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMapTest {
    //Need to write tests
    @Test
    public void mapPutAndEmptyTest1(){
        DashaMapOne dm1 = new DashaMapOne();

        dm1.put("help", 1);
        boolean assertMapContains = dm1.isEmpty();

        Assert.assertFalse(assertMapContains);
    }

    @Test
    public void mapPutAndEmptyTest2(){
        DashaMapTwo dm2 = new DashaMapTwo();

        dm2.put("helper", 1);
        boolean assertMapContains = dm2.isEmpty();

        Assert.assertFalse(assertMapContains);
    }

    @Test
    public void mapPutAndEmptyTest3(){
        DashaMapThree dm3 = new DashaMapThree();

        dm3.put("help", 1);
        boolean assertMapContains = dm3.isEmpty();

        Assert.assertFalse(assertMapContains);
    }

    @Test
    public void mapSetAndGetTest1(){
        DashaMapOne dm1 = new DashaMapOne();

        dm1.set("help", 1);
        dm1.get("help");
        Integer expected = 1;

        Assert.assertEquals(expected, dm1.get("help"));
    }

    @Test
    public void mapSetAndGetTest2(){
        DashaMapTwo dm2 = new DashaMapTwo();

        dm2.set("helper", 1);
        dm2.get("helper");
        Integer expected = 1;

        Assert.assertEquals(expected, dm2.get("helper"));
    }

    @Test
    public void mapSetAndGetTest3(){
        DashaMapThree dm3 = new DashaMapThree();

        dm3.set("help", 1);
        dm3.get("help");
        Integer expected = 1;

        Assert.assertEquals(expected, dm3.get("help"));
    }

    @Test
    public void mapDeleteTest1(){
        DashaMapOne dm1 = new DashaMapOne();

        dm1.put("help", 1);
        dm1.delete("help");

        boolean assertEmpty = dm1.isEmpty();

        Assert.assertTrue(assertEmpty);
    }

    @Test
    public void mapDeleteTest2(){
        DashaMapTwo dm2 = new DashaMapTwo();

        dm2.put("helper", 1);
        dm2.delete("helper");

        boolean assertEmpty = dm2.isEmpty();

        Assert.assertTrue(assertEmpty);
    }

    @Test
    public void mapDeleteTest3(){
        DashaMapThree dm3 = new DashaMapThree();

        dm3.put("help", 1);
        dm3.delete("help");

        boolean assertEmpty = dm3.isEmpty();

        Assert.assertTrue(assertEmpty);
    }

    @Test
    public void mapSizeTest1(){
        DashaMapOne dm1 = new DashaMapOne();

        dm1.put("help", 1);
        dm1.put("hello", 2);
        dm1.put("high", 3);
        long expected = 3;

        Assert.assertEquals(expected, dm1.size());
    }

    @Test
    public void mapSizeTest2(){
        DashaMapTwo dm2 = new DashaMapTwo();

        dm2.put("helper", 1);
        dm2.put("hello", 2);
        dm2.put("highest", 3);
        long expected = 3;

        Assert.assertEquals(expected, dm2.size());
    }

    @Test
    public void mapSizeTest3(){
        DashaMapThree dm3 = new DashaMapThree();

        dm3.put("help", 1);
        dm3.put("give", 2);
        dm3.put("ice", 3);
        long expected = 3;

        Assert.assertEquals(expected, dm3.size());
    }

    @Test
    public void mapBucketTest1(){
        DashaMapOne dm1 = new DashaMapOne();

        dm1.put("help", 1);
        dm1.put("hello", 2);
        dm1.put("high", 3);

        boolean expected = dm1.bucketSize("help");

        Assert.assertTrue(expected);
    }

    @Test
    public void mapBucketTest2(){
        DashaMapTwo dm2 = new DashaMapTwo();

        dm2.put("helper", 1);
        dm2.put("hello", 2);
        dm2.put("highest", 3);

        boolean expected = dm2.bucketSize("hello");

        Assert.assertTrue(expected);
    }

    @Test
    public void mapBucketTest3(){
        DashaMapThree dm3 = new DashaMapThree();

        dm3.put("help", 1);
        dm3.put("give", 2);
        dm3.put("ice", 3);

        boolean expected = dm3.bucketSize("ice");

        Assert.assertTrue(expected);
    }

    @Test
    public void mapBucketCollisionTest1(){
        DashaMapOne dm1 = new DashaMapOne();

        dm1.put("help", 1);
        dm1.put("high", 2);
        dm1.put("hop", 3);

        boolean expected1 = dm1.bucketSize("help");
        boolean expected2 = dm1.bucketSize("high");
        boolean expected3 = dm1.bucketSize("hop");

        Assert.assertTrue(expected1);
        Assert.assertTrue(expected2);
        Assert.assertTrue(expected3);

    }

    @Test
    public void mapBucketCollisionTest2(){
        DashaMapTwo dm2 = new DashaMapTwo();

        dm2.put("helper", 1);
        dm2.put("highest", 2);
        dm2.put("hopper", 3);

        boolean expected1 = dm2.bucketSize("helper");
        boolean expected2 = dm2.bucketSize("highest");
        boolean expected3 = dm2.bucketSize("hopper");

        Assert.assertTrue(expected1);
        Assert.assertTrue(expected2);
        Assert.assertTrue(expected3);

    }

    @Test
    public void mapBucketCollisionTest3(){
        DashaMapThree dm3 = new DashaMapThree();

        dm3.put("help", 1);
        dm3.put("high", 2);
        dm3.put("hop", 3);

        boolean expected1 = dm3.bucketSize("help");
        boolean expected2 = dm3.bucketSize("high");
        boolean expected3 = dm3.bucketSize("hop");

        Assert.assertTrue(expected1);
        Assert.assertTrue(expected2);
        Assert.assertTrue(expected3);

    }
}
