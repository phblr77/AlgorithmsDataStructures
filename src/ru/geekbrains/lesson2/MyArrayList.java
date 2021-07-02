package ru.geekbrains.lesson2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E extends Comparable<E>> {
    private E[] list;
    private int size;
    private int modCount = 0;

    private final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (E[]) new Comparable[capacity];
    }

    public MyArrayList() {
        list = (E[]) new Comparable[DEFAULT_CAPACITY];
    }
    //done
    public void add(E item) {
        //  проверить переполнение и при необходимости увеличиваем массив на size/2 +1
        ensureCapacityInternal(size + 1);
        list[size] = item;
        size++;
    }
    //done
    public void add(int index, E item) {
        // проверить корректность index  [0..size]
        //  проверить переполнение и при необходимости увеличиваем массив на size/2 +1
        rangeCheckForAdd(index);

        ensureCapacityInternal(size + 1);
        System.arraycopy(list, index, list, index + 1,
                size - index);
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(list, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        if (minCapacity - list.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {

    }

    private  int calculateCapacity(E[] list, int minCapacity) {
        if (list == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }
    //done
    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // проверить корректность index  [0..size)
        rangeCheckForAdd(index);
        for (int i = index; i <= size; i++) {
            list[i] = list[i + 1];
        }
        size--;
        list[size] = null;
    }

    public boolean remove(E item) {
        int i = index(item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    public E get(int index) {
        // проверить корректность index  [0..size)
        rangeCheckForAdd(index);
        return list[index];
    }

    public boolean contains(E item) {
        return index(item) > -1;
    }

    public int indexOf(E item) {
        return index(item);
    }

    private int index(E item) {
        int i;
        for (i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }


    private boolean less(E item1, E item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        E temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }


    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        E key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }

}

