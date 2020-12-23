package com.sergsnmail.level1.lesson6;

public class Cat extends Animal {

    private final int MAX_RUN_DISTANCE = 200;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance == 0) {
            System.out.printf("%s остался на месте\n", toString());
        } else if (distance > 0 && distance <= MAX_RUN_DISTANCE){
            System.out.printf("%s пробежал %s m\n", toString(), distance);
        } else {
            System.out.printf("%s не может пробежать %s m\n", toString(), distance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s не умеет плавать\n", toString());
    }

    @Override
    public String toString() {
        return "Кот " + getName();
    }

}
