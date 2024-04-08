package com.github.zipcodewilmington;

import java.util.Objects;

public class DashaMapTwo implements HashMapX{
    private static final int SIZE = 26;
    private DashaMapTwo.Node[] table;

    public DashaMapTwo(){
        table = new DashaMapTwo.Node[SIZE];
    }

    private static class Node{
        String key;
        Integer value;
        Node next;

        Node(String key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

    private String hashFunctionTwo(String input) {
        if (input.length() > 0) {
            return String.valueOf(Character.toLowerCase(input.charAt(1)));
        }
        return null;
    }

    @Override
    public void put(String key, Integer value) {
        String hashString = Objects.requireNonNull(hashFunctionTwo(key));
        int index = Math.abs(hashString.hashCode() % SIZE);

//        if(hashString.length() < 2){
//            return;
//        }
//        int index = hashString.charAt(1) - 'a'; // Convert first character to zero-based index
        // If the bucket is empty, create a new node
        if (table[index] == null) {
            table[index] = new DashaMapTwo.Node(key, value);
            return;
        }

        // Traverse the linked list to find the key
        DashaMapTwo.Node current = table[index];
        while (current != null) {
            // If the key is found, update its value
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            // If the key is not found and there are more nodes, move to the next node
            if (current.next != null) {
                current = current.next;
            } else {
                // If we've reached the end of the linked list, create a new node
                current.next = new DashaMapTwo.Node(key, value);
                return;
            }
        }
    }
    @Override
    public void set(String key, Integer value) {
        String hashString = Objects.requireNonNull(hashFunctionTwo(key));
        int index = Math.abs(hashString.hashCode() % SIZE);
//        if(hashString.length() < 2){
//            return;
//        }
//        int index = hashString.charAt(1) - 'a'; // Convert first character to zero-based index

        // If the bucket is empty, create a new node
        if (table[index] == null) {
            table[index] = new DashaMapTwo.Node(key, value);
            return;
        }

        // Traverse the linked list to find the key
        DashaMapTwo.Node current = table[index];
        while (current != null) {
            // If the key is found, update its value
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            // If the key is not found and there are more nodes, move to the next node
            if (current.next != null) {
                current = current.next;
            } else {
                // If we've reached the end of the linked list, create a new node
                current.next = new DashaMapTwo.Node(key, value);
                return;
            }
        }
    }

    @Override
    public Integer delete(String key) {
        String hashString = Objects.requireNonNull(hashFunctionTwo(key));
        int index = Math.abs(hashString.hashCode() % SIZE);
//        if(hashString.length() < 2){
//            return null;
//        }
//        int index = hashString.charAt(1) - 'a'; // Convert first character to zero-based index
        DashaMapTwo.Node prev = null;
        DashaMapTwo.Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    table[index] = current.next;
                }
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null; // Key not found
    }

    @Override
    public Integer get(String key) {
        String hashString = Objects.requireNonNull(hashFunctionTwo(key));
        int index = Math.abs(hashString.hashCode() % SIZE);
//        if(hashString.length() < 2){
//            return null;
//        }
//        int index = hashString.charAt(1) - 'a'; // Convert first character to zero-based index
        DashaMapTwo.Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    @Override
    public boolean isEmpty() {
        for(Node node : table){
            if(node != null){
                return false;//If one bucket is not empty return false
            }
        }
        return true;//Else return true
    }

    @Override
    public long size() {
        long count = 0;
        for(Node node : table){
            Node current = node;
            while(current != null){
                count++;//Increment for each bucket that isnt null/empty
                current = current.next;
            }
        }
        return count;
    }

    @Override
    public boolean bucketSize(String key) {
        String hashString = Objects.requireNonNull(hashFunctionTwo(key));
//        if(hashString.length() < 2){
//            return false;
//        }
//        int index = hashString.charAt(1) - 'a'; // Convert first character to zero-based index
        int index = Math.abs(hashString.hashCode() % SIZE);
        DashaMapTwo.Node current = table[index];
        //int size = 0;

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                //size++;
                return true;
            }
            current = current.next;
        }
        //return size;
        return false;
    }
}
