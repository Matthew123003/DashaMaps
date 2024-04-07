package com.github.zipcodewilmington;

public class DashaMapThree implements HashMapX{

    private String HashFunctionThree(String input) {
        if (input.length() > 1) {
            return String.toLowerCase(String.valueOf(input.charAt(0)+input.charAt(1)));
        }
        return null;
    }

    @Override
    public void set(String key, Integer value) {

    }

    @Override
    public Integer delete(String key) {
        return null;
    }

    @Override
    public Integer get(String key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public boolean bucketSize(String key) {
        return false;
    }
}
