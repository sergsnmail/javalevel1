package com.sergsnmail.level1.lesson7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /**
         * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
         * потом вывести информацию о сытости котов в консоль.
         */

        Cat[] cats = new Cat[10];

        /**
         * 5.1 Сытость для котэ определяется через случайное число в диапазоне [10..20]
         */
        Random rnd = new Random();
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat" + (i + 1), rnd.nextInt(11) + 10);
        }

        /**
         * 5.2 Создаем тарелку
         */
        Plate plate = new Plate(100);
        plate.info();

        /**
         * 5.3 Заставляем котов поесть из тарелки
         */
        for (Cat cat : cats) {
            cat.eat(plate);
        }

        /**
         * 5.4 Смотрим кто поел, а кто нет
         */
        for (Cat cat : cats) {
            System.out.printf("%s with %s appetite is full -> %s\n", cat.getName(), cat.getAppetite(), cat.isFull());
        }

        /**
         * 5.5 Смотрим сколько осталось еды в тарелке
         */
        plate.info();
    }
}
