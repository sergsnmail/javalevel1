public class Lesson1 {
    /**
     * 1. Создать пустой проект в IntelliJ IDEA и прописать метод main()
     */
    public static void main(String[] args) {

        /**
         * 2. Создать переменные всех пройденных типов данных и инициализировать их значения.
         */
        byte byte1 = 1;
        short shot1 = 2;
        int int1 = 3;
        long long1 = 4l;

        float fl = 5f;
        double db = 6d;

        char ch = 109, ch1 = 'm';
        //System.out.println(ch + " " + ch1);
        boolean isTrue = false;

        String str = "Строка.";

        /**
         * Тест. Задание №3
         */
        float a = 15f, b = 5f, c = 3f, d = 4f;
        System.out.println("\nТест. Задание №3");
        System.out.println(a + " * (" + b + " + (" + c + " / " + d + ")) = " + calcExpression(a, b, c, d));
        System.out.print("Проверка деления на 0: ");
        d = 0.0f;
        System.out.println(a + " * (" + b + " + (" + c + " / " + d + ")) = " + calcExpression(a, b, c, d));

        /**
         * Тест. Задание №4
         */
        System.out.println("\nТест. Задание №4");
        int e = 15, f = 5;
        System.out.println("Сумма(" + e + "," + f + ") = " + (e + f) + " находится в пределах [10 , 20]? - " + isInRange(e, f));
        f = 6;
        System.out.println("Сумма(" + e + "," + f + ") = " + (e + f) + " находится в пределах [10 , 20]? - " + isInRange(e, f));
        f = 1;
        System.out.println("Сумма(" + e + "," + f + ") = " + (e + f) + " находится в пределах [10 , 20]? - " + isInRange(e, f));
        e = 5;
        f = 5;
        System.out.println("Сумма(" + e + "," + f + ") = " + (e + f) + " находится в пределах [10 , 20]? - " + isInRange(e, f));
        f = 4;
        System.out.println("Сумма(" + e + "," + f + ") = " + (e + f) + " находится в пределах [10 , 20]? - " + isInRange(e, f));

        /**
         * Тест. Задание №5
         */
        System.out.println("\nТест. Задание №5");
        checkPositiveOrNegative(-1);
        checkPositiveOrNegative(0);
        checkPositiveOrNegative(1);

        /**
         * Тест. Задание №6
         */
        System.out.println("\nТест. Задание №6");
        e = 1;
        System.out.println("Число " + e + " отрицательное? - " + isNegative(e));
        e = 0;
        System.out.println("Число " + e + " отрицательное? - " + isNegative(e));
        e = -1;
        System.out.println("Число " + e + " отрицательное? - " + isNegative(e));

        /**
         * Тест. Задание №7
         */
        System.out.println("\nТест. Задание №7");
        String name = "Сергей";
        sayHello(name);

        /**
         * Тест. Задание №8
         */
        System.out.println("\nТест. Задание №8");
        int lastYear = 2020;
        for (int i = 0; i <= lastYear; i++) {
            System.out.print("Год " + i + ": ");
            checkYear(i);
        }

    }

    /**
     * 3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     * где a, b, c, d – аргументы этого метода, имеющие тип float.
     */
    private static float calcExpression(float a, float b, float c, float d) {
        if (d == 0.0) {
            System.out.println("Неправильный переданный аргумент. 'd' не должен быть 0.");
            return 0f;
        }
        return a * (b + (c / d));
    }

    /**
     * 4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
     * (включительно), если да – вернуть true, в противном случае – false.
     */
    private static boolean isInRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    /**
     * 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
     * положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    private static void checkPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }

    /**
     * 6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
     * если число отрицательное, и вернуть false если положительное.
     */
    private static boolean isNegative(int a) {
        return a < 0;
    }

    /**
     * 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в
     * консоль сообщение «Привет, указанное_имя!».
     */
    private static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /**
     * 8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    private static void checkYear(int year) {
        if (year <= 0) {
            System.out.println("Число года должно быть больше 0");
            //} else if ((year % 4 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
        } else if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }

}

