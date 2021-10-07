package collections.impl;

import collections.HashTable;

public class HashTableOpenInd implements HashTable {

    Integer[] array;

    public HashTableOpenInd() {
        // Length of 19 can be replaced by any prime number
        array = new Integer[19];
    }

    @Override
    public void add(Integer value) {
        int index = hashFunction(value);
        int step = hashFunction2(value);
        System.out.print("Trying to add value " + value + " at hashIndex " + index + ", ");
        int n = 0;
        while (array[index] != null && n < array.length - 1) {
            if (index + step < array.length - 1) index += step;
            else {
                index = (index + step) % array.length;
            }
            n++;
        }
        if (n == array.length - 1) {
            System.out.println("HashTable is full, impossible to add " + value);
        } else {
            array[index] = value;
            System.out.println("added at hashIndex " + index + " (step = " + step + ")");
        }
    }

    @Override
    public int find(Integer key) {
        int index = hashFunction(key);
        int step = hashFunction2(key);
        int n = 0;
        while (null != array[index] && !key.equals(array[index]) && n < array.length - 1) {
            if (index + step < array.length - 1) index += step;
            else {
                index = (index + step) % array.length;
            }
            n++;
        }
        if (n == array.length - 1 || null == array[index]) {
            System.out.println("Not found value " + key);
            return -1;
        }
        System.out.println("Found key " + key + " at index " + index);
        return index;
    }

    @Override
    public void delete(Integer key) {

        int index = hashFunction(key);
        int step = hashFunction2(key);
        int n = 0;
        while (null != array[index] && !key.equals(array[index]) && n < array.length - 1) {
            if (index + step < array.length - 1) index += step;
            else {
                index = (index + step) % array.length;
            }
            n++;
        }
        if (n == array.length - 1) {
            System.out.println("Not found key " + key);
            return;
        }
        array[index] = null;
        System.out.println("Deleted key " + key + " from index " + index);
    }

    @Override
    public void print() {
        for (Integer integer : array) {
            System.out.print(null == integer ? "* " : integer + " ");
        }
        System.out.println();
    }

    private int hashFunction(Integer value) {
        return value % array.length;
    }

    private int hashFunction2(Integer value) {
        return 7 - (value % 7);
    }
}
