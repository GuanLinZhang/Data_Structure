package StackAndQueueAndList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements Iterable<E> {
    private int N;
    private Node first;

    private class Node {
        private E elem;
        private Node next;
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int Size() {
        return N;
    }

    public void push(E elem) {
        Node oldNode = first;
        first = new Node();
        first.elem = elem;
        first.next = oldNode;
        N++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E elem = first.elem;
            first = first.next;
            N--;
            return elem;
        }
    }


    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.elem;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                E elem = current.elem;
                current = current.next;
                return elem;
            }
        }

    }
}
