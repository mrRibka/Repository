package org.example;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private int index;
    private E[] values;

    public ArrayIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }

    @Override
    public void remove() {
    }
}
