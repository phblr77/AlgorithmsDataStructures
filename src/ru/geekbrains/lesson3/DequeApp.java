package ru.geekbrains.lesson3;

import java.util.EmptyStackException;

public class DequeApp<Item extends Comparable> {
    private Item[] array;
    private final int DEFAULT_CAPACITY = 10;
    private int head;
    private int tail;

    public DequeApp() {
        array = (Item[]) new Comparable[DEFAULT_CAPACITY];
        head = 0;
        tail = 0;
    }

    public DequeApp(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("invalid capacity " + capacity);
        }
        array = (Item[]) new Comparable[capacity];
        head = 0;
        tail = 0;
    }

    public void insertRight(Item item) {
        if (isFull()) {
            reCapacity(array.length + DEFAULT_CAPACITY);
        }
        if (!isEmpty()) {
            tail = shiftEndOutward();
        }
        array[tail] = item;
    }

    public void insertLeft(Item item) {
        if (isFull()) {
            reCapacity(array.length + DEFAULT_CAPACITY);
        }
        if (!isEmpty()) {
            head = shiftBeginOutward();
        }
        array[head] = item;
    }

    public Item removeLeft() {
        Item value = peekLeft();
        array[head] = null;
        head = shiftBeginInward();
        isEmpty();
        return value;
    }

    public Item removeRight() {
        Item value = peekRight();
        array[tail] = null;
        tail = shiftEndInward();
        isEmpty();
        return value;
    }

    public Item peekLeft() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[head];
    }

    public Item peekRight() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[tail];
    }

    private int nextRightIndex(int index) {
        return (index + 1) % array.length;
    }


    private int nextLeftIndex(int index) {
        return index != 0 ? index - 1 : array.length - 1;
    }

    private int shiftBeginOutward() {
        return nextLeftIndex(head);
    }


    private int shiftEndOutward() {
        return nextRightIndex(tail);
    }


    private int shiftBeginInward() {
        return nextRightIndex(head);
    }


    private int shiftEndInward() {
        return nextLeftIndex(tail);
    }

    public int queueLength() {
        if (tail != head && array[head] != null && array[tail] != null) {
            return isOrder() ? tail - head + 1 : array.length - head + tail + 1;//e2 b5 = 8 (10 - 5 + 2 + 1)
        } else {
            if (array[head] != null && array[tail] != null) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    public boolean isEmpty() {
        if (queueLength() == 0 && array.length > DEFAULT_CAPACITY) {
            resetCapacity();
            return true;
        }
        return queueLength() == 0;
    }


    public void resetCapacity() {
        Item[] tempArr = (Item[]) new Comparable[DEFAULT_CAPACITY];
        array = tempArr;
        head = 0;
        tail = 0;
    }

    public boolean isFull() {
        return queueLength() == array.length;
    }

    private boolean isOrder() {
        return tail >= head;
    }

    public void reCapacity(int newCapacity) {
        Item[] tempArr = (Item[]) new Comparable[newCapacity];
        int delta = newCapacity - array.length;
        if (isOrder()) {
            System.arraycopy(array, head, tempArr, head + delta / 2, queueLength());
            head += delta / 2;
            tail += delta / 2;
        } else {
            System.arraycopy(array, 0, tempArr, 0, tail + 1);
            System.arraycopy(array, head, tempArr, head + delta, array.length - head);
            head += delta;
        }
        array = tempArr;
    }


    public int size() {
        return array.length;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString();
    }

}
