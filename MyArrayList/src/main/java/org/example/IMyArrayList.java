package org.example;

public interface IMyArrayList<E> extends Iterable<E>{
    boolean add(E e);
    int size();
    E get(int index);
    void update(int index, E e);
}
