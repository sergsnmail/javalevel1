package com.sergsnmail.level1.lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Animal("Барсук"),
                new Animal("Енот"),
                new Dog("Бобик"),
                new Dog("Шарик"),
                new Dog("Дружок"),
                new Dog("Тузик"),
                new Cat("Мурзик"),
                new Cat("Пушок"),
                new Cat("Гав")
        };

        /**
         * 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
         * Результатом выполнения действия будет печать в консоль.
         * Например:
         * dogBobik.run(150); -> 'Бобик пробежал 150 м.';
         */

        Random rnd = new Random();
        /**
         * Заставим животных побегать
         */
        System.out.println("\nЗаставим животных побегать:");
        for (Animal animal : animals) {
            animal.run(rnd.nextInt(1000));
        }

        /**
         * Заставим животных поплавать
         */
        System.out.println("\nЗаставим животных поплавать:");
        for (Animal animal : animals) {
            animal.swim(rnd.nextInt(15));
        }

        /**
         * 4. * Добавить подсчет созданных котов, собак и животных.
         */
        int catCount = 0, dogCount = 0, animalCount = 0;
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                dogCount++;
            } else if (animal instanceof Cat) {
                catCount++;
            } else {
                animalCount++;
            }
        }

        System.out.printf("\nВсего:\n %s животных\n %s собак\n %s кошек", animalCount, dogCount, catCount);
    }
}
