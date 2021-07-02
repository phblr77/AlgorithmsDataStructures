package ru.geekbrains.lesson3;

import java.util.EmptyStackException;

public class StackApp<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public StackApp(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public StackApp() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }


    //3. Реализовать расширение массива в стеке при заполнении стека.
    public void push(T item) {
        if (isFull()) {
            //throw new StackOverflowError();
            T[] tempArr = (T[]) new Object[list.length * 2];
            System.arraycopy(list, 0, tempArr, 0, size);
            list = tempArr;
        }
        list[size] = item;
        size++;
    }

    public T pop() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
    }
}
