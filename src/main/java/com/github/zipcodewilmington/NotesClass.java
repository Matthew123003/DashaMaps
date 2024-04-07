package com.github.zipcodewilmington;

public class NotesClass {

//    Implement Hashing Functions: You're given three hashing functions, HashFunctionOne,
//    HashFunctionTwo, and HashFunctionThree. Each function takes a string input and returns a
//    hashed value based on different criteria (first character, second character, or first two
//    characters). You need to implement these functions as part of each corresponding DashaMapX class.
//
//    Create DashaMap Classes: Implement three classes, DashaMapOne, DashaMapTwo, and DashaMapThree,
//    each implementing the HashMapX interface. Each class should have its own hashing function and
//            handle collisions by using linked lists.
//
//    Initialize Hash Array: Each DashaMapX class should have an array of Node objects,
//        initialized to a length of 26 (for each letter of the alphabet). Each array slot
//    will contain a linked list of Node objects.
//
//    Implement HashMapX Interface Methods:
//
//    set(String key, String value): Use the corresponding hash function to determine
//    the index in the hash array. Create a new Node object with the key-value pair and append it
//    to the linked list at that index.
//    get(String key): Use the hash function to find the index in the hash array. Search the linked
//    list at that index for the node with the matching key and return its value.
//    delete(String key): Implement a method to delete a node with the given key from the hash map.
//    This may involve removing the node from the linked list.
//    isEmpty(): Check if the hash map is empty.
//    size(): Return the size of the hash map.
//    bucketSize(String key): This method is used for testing purposes. It should return
//    whether a bucket (linked list) at a specific index contains a node with the given key.
//    Test Harness: Implement a test harness to read in a list of words from wordlist.txt. For
//    each word, insert it into each of the three hash maps with its corresponding integer value.
//
//    Node Class: Implement a Node class with fields for the key (k), value (v), and a
//    reference to the next node (next). This class will be used to create linked lists in the
//            hash maps to handle collisions.
//
//    Handle Collisions: When inserting elements into the hash maps, handle collisions
//    by appending new nodes to the linked list at the corresponding index in the hash array.
//
//    Handle Deletions: Implement a method to delete nodes from the hash map. This may
//    involve removing nodes from the linked list at the corresponding index in the hash array.
//
//    Overall, the goal is to implement three hash map classes, each using a
//    different hashing function and handling collisions with linked lists. These hash
//    maps should be able to store key-value pairs, retrieve values by key, delete key-value
//    pairs, and provide methods for testing the internal structure of the hash maps.
}
