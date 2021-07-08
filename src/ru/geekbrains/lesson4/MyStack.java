package ru.geekbrains.lesson4;



//1. Реализовать класс Stack используя класс MyLinkedList
public class MyStack<E> {

    private MyLinkedList<E> list = new MyLinkedList<>();

    public void push(E item){
        list.insertFirst(item);
    }

    public E pop(){
        return list.removeFirst();
    }

    public E peek(){
        return list.getFirst();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }



}
