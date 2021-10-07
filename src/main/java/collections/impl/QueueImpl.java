package collections.impl;

import collections.Queue;

public class QueueImpl<E> implements Queue<E> {

    private Node<E> first;
    private Node<E> last;

    public QueueImpl(E obj) {
        first = new Node<E>(obj, null);
        last = first;
    }

    @Override
    public void add(E obj) {
        Node<E> next = new Node<E>(obj, null);
        last.setNext(next);
        last = next;
        if (null == first) {
            first = last;
        }
    }

    @Override
    public E peek() {
        return first.getObj();
    }

    @Override
    public E remove() {
        E temp = first.getObj();
        first = first.getNext();
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String queueToString() {
        Node<E> current = first;
        String qToString = "";
        while (null != current) {
            qToString += current.getObj() + " ";
            current = current.getNext();
        }
        return qToString;
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
