package com.github.zipcodewilmington;

public class DashaMapTwo implements HashMapX{

    private String HashFunctionTwo(String input) {
        if (input.length() > 0) {
            return String.toLowerCase(String.valueOf(input.charAt(1)));
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
