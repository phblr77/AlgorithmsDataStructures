package ru.geekbrains.lesson6;


//1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать деревьев с глубиной
// в 6 уровней. Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int. Число,
// которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
//2. Проанализировать, какой процент созданных деревьев являются несбалансированными.


import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int numberOfTrees = 1000000;

        int balanced = 0;
        for (int i = 0; i < numberOfTrees; i++) {
            MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
            fillTreeMap(map);
            if (map.isBalanced()) {
                balanced++;
            }
        }
        System.out.println("Из " + numberOfTrees + " MyTreeMap сбалансированы " + balanced + "\r\nнесбалансированы " + (numberOfTrees - balanced) + " деревьев");
        System.out.println("Несбалансированы " + ((((float) (numberOfTrees - balanced)) * 100) / (float) numberOfTrees) + " %");
    }

    public static void fillTreeMap(MyTreeMap<Integer, Integer> MyTreeMap) {
        while (MyTreeMap.height() < 6) {
            MyTreeMap.put(ThreadLocalRandom.current().nextInt(-100, 100), 0);
        }
    }
}

