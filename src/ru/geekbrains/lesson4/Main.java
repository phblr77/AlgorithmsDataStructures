package ru.geekbrains.lesson4;


//1. Реализовать класс Stack используя класс MyLinkedList
//2. Добавить итератор для класса MyLinkedList

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        MyLinkedList<String> list = new MyLinkedList<>();
        list.insertLast("java");
        list.insertLast("python");
        list.insertLast("c++");
        list.insertLast("c#");
        list.insertFirst("kotlin");
        list.removeLast();
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
