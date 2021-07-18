package ru.geekbrains.lesson8;

public class Main {
    public static void main(String[] args) {

        ChainingHashMap<Integer, String> map = new ChainingHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(12, "12");
        map.put(15, "15");
        map.put(3, "three");
        map.put(4, "four");
        map.put(11, "11");
        map.put(20, "20");

        System.out.println(map);
        System.out.println("map.get(155): " + map.get(155));
        System.out.println("map.delete(2): " + map.delete(2));
        System.out.println("map.delete(20): " + map.delete(20));
        System.out.println("map.delete(15): " + map.delete(15));
        System.out.println("map.delete(2) again: " + map.delete(2));
        System.out.println(map);


    }
}
