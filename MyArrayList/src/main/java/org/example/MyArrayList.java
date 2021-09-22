package org.example;

import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class MyArrayList<E> implements IMyArrayList<E> {
    public static void main( String[] args ) {
        MyArrayList<String> strings = new MyArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.update(1, "update");
        System.out.println(strings.get(1));
    }
    private E[] values;

    MyArrayList(){
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        }
        catch (ClassCastException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(values);
    }
}
