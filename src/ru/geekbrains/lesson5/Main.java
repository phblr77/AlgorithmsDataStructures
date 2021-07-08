package ru.geekbrains.lesson5;


//1. Написать программу по возведению числа в степень с помощью рекурсии.
//2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
public class Main {
    public static void main(String[] args) {
        Item[] arrOfItems = {new Item(1, 3),
                new Item(6, 4),
                new Item(4, 5),
                new Item(7, 8),
                new Item(6, 9)};

        Backpack backpack = new Backpack(arrOfItems);
        int capacity = 15;
        System.out.println("Задание 2");
        System.out.println(backpack.recursiveBestSum(arrOfItems.length - 1, capacity));
        System.out.println("Задание 1");
        System.out.println(pow(2, -3));
    }


    //Задание 1
    public static double pow(double value, double powValue) {
        if (value == 0 && powValue <= 0) {
            throw new ArithmeticException("Вы ввели недопустимые значения");
        }
        if (powValue == 0) {
            return 1;
        } else if (powValue < 0) {
            return 1 / value * pow(value, ++powValue);
        } else {
            return value * pow(value, --powValue);
        }
    }
}
