package com.github.zipcodewilmington;

//import jdk.nashorn.internal.ir.Node;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap implements HashMapX{

    private static final int SIZE = 26;
    private Node[] table;

    public DashaMap(){
        table = new Node[SIZE];
    }

    private static class Node{
        String key;
        String value;
        Node next;

        Node(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
    @Override
    public void set(String key, String value) {
        int index = hash(key);

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

    private int hash(String key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    @Override
    public String delete(String key) {
        int index = hash(key);
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
    public String get(String key) {
        int index = hash(key);
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
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
