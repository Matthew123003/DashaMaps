package com.github.zipcodewilmington;

//import jdk.nashorn.internal.ir.Node;

import java.util.Objects;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMapOne implements HashMapX{

    private static final int SIZE = 26;
    private Node[] table;

    public DashaMapOne(){
        table = new Node[SIZE];
    }

    static class Node{
        String key;
        Integer value;
        Node next;

        Node(String key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

        private int hash(String key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    private String hashFunctionOne(String input) {
        if (input.length() > 0) {
            return String.valueOf(Character.toLowerCase(input.charAt(0)));
        }
        return null;
    }
    @Override
    public void set(String key, Integer value) {
        int index = Integer.parseInt(Objects.requireNonNull(hashFunctionOne(key)));

        // If the bucket is empty, create a new node
        if (table[index] == null) {
            table[index] = new Node(key, value);
            return;
        }

        // Traverse the linked list to find the key
        Node current = table[index];
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
                current.next = new Node(key, value);
                return;
            }
        }
    }


    @Override
    public Integer delete(String key) {
        int index = Integer.parseInt(Objects.requireNonNull(hashFunctionOne(key)));
        Node prev = null;
        Node current = table[index];

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
        int index = Integer.parseInt(Objects.requireNonNull(hashFunctionOne(key)));
        Node current = table[index];

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
        for (Node node : table) {
            if (node != null) {
                return false; // If at least one bucket is not empty, return false
            }
        }
        return true; // All buckets are empty
    }

    @Override
    public long size() {
        long count = 0;
        for (Node node : table) {
            Node current = node;
            while (current != null) {
                count++; // Increment count for each key-value pair in the bucket
                current = current.next;
            }
        }
        return count;
    }

    @Override
    public boolean bucketSize(String key) {
        int index = Integer.parseInt(Objects.requireNonNull(hashFunctionOne(key)));
        Node current = table[index];
        //int size = 0;

        while (current != null) {
            if (current.key.equals(key)) {
                //size++;
                return true;
            }
            current = current.next;
        }
        //return size;
        return false;
    }
}
