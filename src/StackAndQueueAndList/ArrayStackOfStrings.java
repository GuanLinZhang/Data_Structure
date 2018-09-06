package StackAndQueueAndList;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayStackOfStrings implements Iterable<String> {
    private String[] items;
    private int n;

    public ArrayStackOfStrings(int capacity) {
        items = new String[capacity];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == items.length;
    }

    public void push(String item) {
        if(!isFull()) {
            items[n++] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public String pop() {
        if(!isEmpty()) {
            return items[--n];
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<String> {
        private int i = n - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public String next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[n--];
        }
    }
}