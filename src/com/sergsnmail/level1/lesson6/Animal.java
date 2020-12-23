package com.sergsnmail.level1.lesson6;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int distance) {
        if (distance > 0) {
            System.out.printf("%s пробежал %s m\n",toString(), distance);
        } else {
            System.out.printf("%s остался на месте\n",toString());
        }
    }

    public void swim(int distance) {
        if (distance > 0) {
            System.out.printf("%s проплыл %s m\n",toString(), distance);
        } else {
            System.out.printf("%s остался на месте\n",toString());
        }
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Животное " + getName();
    }
}
