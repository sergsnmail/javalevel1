package com.sergsnmail.level1.lesson6;

public class Dog extends Animal {

    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void swim(int distance) {
        if (distance == 0) {
            System.out.printf("%s остался на месте\n", toString());
        } else if (distance > 0 && distance <= MAX_SWIM_DISTANCE) {
            System.out.printf("%s проплыл %s m\n", toString(), distance);
        } else {
            System.out.printf("%s не может проплыть %s m\n", toString(), distance);
        }
    }

    @Override
    public void run(int distance) {
        if (distance == 0) {
            System.out.printf("%s остался на месте\n", toString());
        } else if (distance > 0 && distance <= MAX_RUN_DISTANCE) {
            System.out.printf("%s пробежал %s m\n", toString(), distance);
        } else {
            System.out.printf("%s не может пробежать %s m\n", toString(), distance);
        }
    }

    @Override
    public String toString() {
        return "Собака " + getName();
    }
}
