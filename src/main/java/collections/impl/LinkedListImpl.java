package collections.impl;

import collections.List;

import java.util.NoSuchElementException;

public class LinkedListImpl<E> implements List<E> {

    private Node<E> first;

    public int indexOf(E obj) {
        Node<E> current = first;
        int index = 0;
        boolean has = false;
        while (null != current) {
            if (!obj.equals(current.getObj())) {
                index++;
                current = current.getNext();
            } else {
                has = true;
                break;
            }
        }
        if (first == null || !has) return -1;
        else return index;
    }

    public int size() {
        if (first == null) return 0;
        else {
            int s = 1;
            Node<E> current = first;
            while (null != current.getNext()) {
                s++;
                current = current.getNext();
            }
            return s;
        }
    }

    public boolean contains(E obj) {
        Node<E> current = first;
        while (null != current) {
            if (obj.equals(current.getObj())) return true;
            current = current.getNext();
        }
        return false;
    }

    public void add(E obj) {
        if (null == first) {
            first = new Node<>(obj, null);
        } else {
            first = new Node<>(obj, first);
        }
    }

    public void removeByKey(E key) {
        Node<E> current = first;
        if (key.equals(current.getObj())) {
            first = current.getNext();
            return;
        }
        while (null != current.getNext() && !key.equals(current.getNext().getObj())) {
            current = current.getNext();
        }
        if (null != current.getNext()) {
            current.setNext(current.getNext().getNext());
        }
    }

    public void removeByIndex(int index) throws NoSuchElementException {
        int s = size();
        if (isEmpty() || index < 0 || index >= s) throw new NoSuchElementException("No such element");
        else if (index == 0) first = first.getNext();
        else {
            Node<E> current = first;
            for (int i = 1; i < s; i++) {
                if (i == index) {
                    current.setNext(current.getNext().getNext());
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public E get(int index) throws NoSuchElementException {
        if (null == first) throw new NoSuchElementException("No elements in list");
        else {
            Node<E> current = first;
            int ind = 0;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
                ind++;
            }

            if (ind == index && null != current) {
                return current.getObj();
            }
        }
        throw new NoSuchElementException("No element at such index");
    }

    public boolean set(E obj, int index) {
        int s = size() - 1;
        if (index > s || index < 0) {
            return false;
        } else {
            Node<E> current = first;
            int ind = 0;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
                ind++;
            }
            if (ind == index && null != current) {
                current.setObj(obj);
            }
        }
        return true;
    }

    public String listToString() {
        Node<E> current = first;
        String lToString = "";
        while (null != current) {
            lToString += current.getObj().toString() + " ";
            current = current.getNext();
        }
        return lToString;
    }

    private static class Node<E> {

        private E obj;
        private Node<E> next;

        public Node(E obj, Node<E> next) {
            this.obj = obj;
            this.next = next;
        }

        public E getObj() {
            return obj;
        }

        public void setObj(E obj) {
            this.obj = obj;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

}