package ru.geekbrains.lesson5;

public class Backpack {

    private final Item[] items;

    public Backpack(Item[] items) {
        this.items = items;
    }

    int recursiveBestSum(int i, int weight) {
        if (i < 0) {
            return 0;
        }
        if (items[i].getWeight() > weight) {
            return recursiveBestSum(i - 1, weight);
        } else {
            return Math.max(
                    recursiveBestSum(i - 1, weight),
                    recursiveBestSum(i - 1, weight - items[i].getWeight()) + items[i].getPrice());
        }
    }
}
