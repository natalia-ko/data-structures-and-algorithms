package collections.impl;

import collections.HashTable;

import java.util.ArrayList;

//For storing Integers
public class HashTableLinked implements HashTable {
    ArrayList<LinkedListImpl<Integer>> array;
    int size;

    public HashTableLinked() {
        array = new ArrayList<>();
        size = 10;
        for (int i = 0; i < size; i++) {
            array.set(i, null);
        }
    }

    @Override
    public void add(Integer value) {
        int index = hashFunction(value);
        if (array.get(index) == null) {
            LinkedListImpl<Integer> llAtIndex = new LinkedListImpl<>();
            llAtIndex.add(value);
            array.set(index, llAtIndex);
        } else {
            array.get(index).add(value);
        }
    }

    @Override
    public int find(Integer key) {
        int index = hashFunction(key);
        if (null == array.get(index) || array.get(index).indexOf(key) == -1) {
            System.out.println("Does not contain " + key);
            return -1;
        } else {
            System.out.println("Found " + key + " in the list at index " + index);
            return index;
        }
    }

    @Override
    public void delete(Integer key) {
        int index = hashFunction(key);
        if (array.get(index) != null) {
            array.get(index).removeByKey(key);
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            if (null == array.get(i)) {
                System.out.println("*");
            } else {
                LinkedListImpl<Integer> ll = array.get(i);
                System.out.println(ll.listToString());
            }
        }
    }

    private int hashFunction(int key) {
        if (key < 0) {
            key = -1 * key;
        }
        return key % size;
    }
}
