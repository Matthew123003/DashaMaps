package com.github.zipcodewilmington;

import java.util.Objects;

public class DashaMapThree implements HashMapX{
    private static final int SIZE =26;
    private DashaMapThree.Node[] table;
    public DashaMapThree(){
        table = new DashaMapThree.Node[SIZE];
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

    private String hashFunctionThree(String input) {
        if (input.length() > 1) {
            return String.valueOf(Character.toLowerCase(input.charAt(0)+input.charAt(1)));
        }
        return null;
    }

    @Override
    public void put(String key, Integer value) {
        String hashString = Objects.requireNonNull(hashFunctionThree(key));
        int index = Math.abs(hashString.hashCode() % SIZE); // Take modulo to ensure index is within bounds


        // If the bucket is empty, create a new node
        if (table[index] == null) {
            table[index] = new DashaMapThree.Node(key, value);
            return;
        }

        // Traverse the linked list to find the key
        DashaMapThree.Node current = table[index];
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
                current.next = new DashaMapThree.Node(key, value);
                return;
            }
        }
    }

    @Override
    public void set(String key, Integer value) {
        String hashString = Objects.requireNonNull(hashFunctionThree(key));
        int index = Math.abs(hashString.hashCode() % SIZE); // Take modulo to ensure index is within bounds


        // If the bucket is empty, create a new node
        if (table[index] == null) {
            table[index] = new DashaMapThree.Node(key, value);
            return;
        }

        // Traverse the linked list to find the key
        DashaMapThree.Node current = table[index];
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
                current.next = new DashaMapThree.Node(key, value);
                return;
            }
        }
    }

    @Override
    public Integer delete(String key) {
        String hashString = Objects.requireNonNull(hashFunctionThree(key));
        int index = Math.abs(hashString.hashCode() % SIZE); // Take modulo to ensure index is within bounds

        DashaMapThree.Node prev = null;
        DashaMapThree.Node current = table[index];

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
        String hashString = Objects.requireNonNull(hashFunctionThree(key));
        int index = Math.abs(hashString.hashCode() % SIZE); // Take modulo to ensure index is within bounds

        DashaMapThree.Node current = table[index];

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
            if( node != null){
                return false;//For each node in the table, check if it isnt null,
                             // if it isnt then it isnt empty
            }
        }
        return true;
    }

    @Override
    public long size() {
        long count = 0;
        for(Node node : table){
            Node current = node;
            while(current != null){
                count++;//increment count if node isnt null/empty
                current = node.next;
            }
        }
        return count;
    }

    @Override
    public boolean bucketSize(String key) {
        String hashString = Objects.requireNonNull(hashFunctionThree(key));
        int index = Math.abs(hashString.hashCode() % SIZE); // Take modulo to ensure index is within bounds

        DashaMapThree.Node current = table[index];
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
