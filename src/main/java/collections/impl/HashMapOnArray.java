package collections.impl;

public class HashMapOnArray<K,E> {
    EntryNode<K, E>[] array;

    @SuppressWarnings("unchecked")
    public HashMapOnArray() {
        array = new EntryNode[10];
    }

    public void add(K key, E value) {
        int index = hashFunction(key);
        if (array[index] == null) {
            array[index] = new EntryNode<K, E>(key, value);
        } else {
            EntryNode<K, E> newEntry = new EntryNode<>(key, value);
            newEntry.next = array[index];
            array[index] = newEntry;
        }
    }

    public E find(K key) {
        int index = hashFunction(key);
        EntryNode<K, E> current = array[index];
        while (null != current) {
            if (current.key.equals(key)) {
                return current.value;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    public void delete(K key) {
        int index = hashFunction(key);
        EntryNode<K, E> current = array[index];
        if (null == current) return;
        if (current.key.equals(key)) {
            array[index] = current.next;
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
        for (int i = 0; i < array.length; i++) {
            System.out.print("at index "+i+"  : ");
            if (null == array[i]) {
                System.out.print("*");
            } else {
                EntryNode<K, E> current = array[i];
                while (null != current) {
                    System.out.print(current.value + "; ");
                    current = current.next;
                }

            }
            System.out.println();
        }
    }


    private int hashFunction(Object key) {
        return key.hashCode() % array.length;
    }


    private static class EntryNode<K, E> {
        K key;
        E value;
        EntryNode<K, E> next;

        public EntryNode(K key, E value) {
            this.key = key;
            this.value = value;
        }
    }
}
