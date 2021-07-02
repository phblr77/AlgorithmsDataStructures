package ru.geekbrains.lesson2;

import java.util.Random;

//1. Создать массив большого размера (100000 элементов).
//2. Заполнить массив случайными числами.
//3. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
//4* . Доработать код с урока добавив проверки в места с комментариями в классе MyArrayList
public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        //Задание 1.
        MyArrayList<Integer> arr = new MyArrayList<>(100000);

        //Задание 2.
        for (int i = 0; i < 100000; i++) {
            arr.add(random.nextInt(80));
        }
        System.out.println("Заполненный массив");
        System.out.println(arr);



        //Задание 3. Сортировка пузырьком
        System.out.println("Сортировка пузырьком");
        long timeStart = System.currentTimeMillis();
        arr.bubbleSort();
        System.out.println("Выполнено за " + (System.currentTimeMillis() - timeStart) + " мс");
        System.out.println(arr);
        System.out.println("Сортировка методом выбора");
        timeStart = System.currentTimeMillis();
        arr.selectionSort();
        System.out.println("Выполнено за " + (System.currentTimeMillis() - timeStart) + " мс");
        System.out.println(arr);
        System.out.println("Сортировка методом вставки");
        timeStart = System.currentTimeMillis();
        arr.insertionSort();
        System.out.println("Выполнено за " + (System.currentTimeMillis() - timeStart) + " мс");
        System.out.println(arr);
    }
}

