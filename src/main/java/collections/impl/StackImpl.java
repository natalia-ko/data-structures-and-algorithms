package collections.impl;

import collections.Stack;

import java.util.Arrays;

public class StackImpl<E> implements Stack<E> {

    private int size;
    private Object[] stack;
    private int topIndex;

    public StackImpl() {
        this.size = 10;
        this.stack = new Object[size];
        this.topIndex = -1;
    }

    @Override
    public void push(E value) {
        if (topIndex < size - 1) {
            topIndex++;
            stack[topIndex] = value;
        } else {
            size = size << 1;
            stack = Arrays.copyOf(stack, size);
            topIndex++;
            stack[topIndex] = value;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        else {
            @SuppressWarnings("unchecked") //stack of Objects of E type guaranteed
            E result = (E) stack[topIndex];
            return result;
        }
    }

    @Override
    public E pop() {
        if (topIndex >= 0) {
            @SuppressWarnings("unchecked") //stack of Objects of E type guaranteed
            E temp = (E) stack[topIndex];
            topIndex--;
            return temp;
        } else {
            throw new IndexOutOfBoundsException("No elements in the stack");
        }
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public String stackToString() {
        String stackToString = "";
        if (topIndex < 0) return stackToString;
        else {
            for (int i = 0; i <= topIndex; i++) {
                stackToString += stack[i].toString() + " ";
            }
        }
        return stackToString;
    }
}
