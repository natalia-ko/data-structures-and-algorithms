package collections.impl;

import java.util.ArrayList;

public class HashMapLinked<E> {
    ArrayList<EntryNode<Integer, E>> array;
    int size;

    public HashMapLinked() {
        array = new ArrayList<>();
        size = 10;
        for (int i = 0; i < size; i++) {
            array.add(null);
        }
    }

    public void add(Integer key, E value) {
        int index = hashFunction(key);
        if (array.get(index) == null) {
            array.set(index, new EntryNode<>(key, value));
        } else {
            EntryNode<Integer, E> newEntry = new EntryNode<>(key, value);
            newEntry.next = array.get(index);
            array.set(index, newEntry);
        }
    }

    public E find(Integer key) {
        int index = hashFunction(key);
        EntryNode<Integer, E> current = array.get(index);
        while (null != current) {
            if (current.key.equals(key)) {
                return current.value;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    public void delete(Integer key) {
        int index = hashFunction(key);
        EntryNode<Integer, E> current = array.get(index);
        if (null == current) return;
        if (current.key.equals(key)) {
            array.set(index, current.next);
        } else {
            while (null != current.next) {
                if (current.next.key.equals(key)) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
                System.out.print("at index "+i+"  : ");
            if (null == array.get(i)) {
                System.out.print("*");
            } else {
                EntryNode<Integer, E> current = array.get(i);
                while (null != current) {
                    System.out.print(current.value + "; ");
                    current = current.next;
                }

            }
            System.out.println();
        }
    }

    private int hashFunction(int key) {
        if (key < 0) {
            key = -1 * key;
        }
        return key % size;
    }


    private static class EntryNode<Integer, E> {
        Integer key;
        E value;
        EntryNode<Integer, E> next;

        public EntryNode(Integer key, E value) {
            this.key = key;
            this.value = value;
        }
    }
}