package ru.geekbrains.lesson3;

//1. Создать программу, которая переворачивает вводимые строки (читает справа налево).
//2. Создать класс для реализации дека.
//3. Реализовать расширение массива в стеке при заполнении стека.


public class Main {
    public static void main(String[] args) {
//Пример для задания 1

        reverseString("java");
        System.out.println();

//2. Создать класс для реализации дека.

        DequeApp<Integer> deque = new DequeApp<>();
        for (int i = 0; i < 11; i++) {
            deque.insertRight(1);
        }

        System.out.println(deque.toString());
        System.out.println(deque.size());
        deque.insertLeft(5);
        deque.insertRight(6);
        deque.insertLeft(7);
        deque.insertRight(8);
        deque.removeLeft();
        deque.removeRight();
        System.out.println(deque.toString());
        System.out.println(deque.peekLeft());
        System.out.println(deque.peekRight());
        System.out.println(deque.size());


//Пример для задания 3. Все работает)
        StackApp<Integer> stackApp = new StackApp<>(2);
        for (int i = 0; i < 100; i++) {
            stackApp.push(1);
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(stackApp.peek() + " ");
        }
        System.out.println();


    }


    //1. Создать программу, которая переворачивает вводимые строки (читает справа налево).

    public static void reverseString(String s) {
        StackApp<Character> stack = new StackApp<>(20);
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            stack.push(charArr[i]);
        }

        for (int i = 0; i < charArr.length; i++) {
            System.out.print(stack.pop());

        }

    }

}
