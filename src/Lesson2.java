import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {
        /**
         * Test. Task №1
         */
        System.out.println("\nTest. Task №1");
        doTask1();

        /**
         * Test. Task №2
         */
        System.out.println("\nTest. Task №2");
        doTask2(8);

        /**
         * Test. Task №3
         */
        System.out.println("\nTest. Task №3");
        doTask3();

        /**
         * Test. Task №4
         */
        System.out.println("\nTest. Task №4");
        int size = 5;
        System.out.println("Array size: " + size);
        int[][] data = doTask4(size);
        printTwoDimensionalArray(data);
        size = 4;
        System.out.println("Array size: " + size);
        data = doTask4(size);
        printTwoDimensionalArray(data);
        size = 3;
        System.out.println("Array size: " + size);
        data = doTask4(size);
        printTwoDimensionalArray(data);
        size = 2;
        System.out.println("Array size: " + size);
        data = doTask4(size);
        printTwoDimensionalArray(data);
        size = 1;
        System.out.println("Array size: " + size);
        data = doTask4(size);
        printTwoDimensionalArray(data);
        size = 0;
        System.out.println("Array size: " + size);
        data = doTask4(size);
        printTwoDimensionalArray(data);

        /**
         * Test. Task №5
         */
        System.out.println("\nTest. Task №5");
        findMinMax(new int[]{10, 2, 5, 12, 45, 32, 1, 0, 140});
        findMinMax(new int[]{0, 2, 5, 16});
        findMinMax(new int[]{45, 32, 34, 50, 99});

        /**
         * Test. Task №6
         */
        System.out.println("\nTest. Task №6");
        System.out.println(" => " + checkBalance(new int[]{1, 2, 3}));
        System.out.println(" => " + checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(" => " + checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(" => " + checkBalance(new int[]{1, 1, 1, 2, 8}));

        /**
         * Test. Task №7
         */
        System.out.println("\nTest. Task №7");
        shiftArray(new int[]{1, 2, 3}, 1);
        shiftArray(new int[]{3, 5, 6, 1}, -2);
        shiftArray(new int[]{1}, 3);
        shiftArray(new int[]{3, 5, 6, 1}, 0);
        shiftArray(new int[]{3, 5, 6, 1}, -9);
        shiftArray(new int[]{3, 5, 6, 1}, 6);
    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    private static void doTask1() {
        int[] data = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Original array => " + Arrays.toString(data));

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i] ^ 1;
        }
        System.out.println("Modified array => " + Arrays.toString(data));
    }

    /**
     * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    private static void doTask2(int size) {
        int[] data = new int[size];
        for (int i = 0, value = 0; i < data.length; i++, value += 3) {
            data[i] = value;
        }

        System.out.println(Arrays.toString(data));
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    private static void doTask3() {
        int[] data = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < data.length; i++) {
            if (data[i] < 6) {
                data[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    private static int[][] doTask4(int size) {
        int[][] data = new int[size][size];
        if (size > 0) {
            for (int i = 0; i < data.length; i++) {
                data[i][i] = 1;
                data[i][data.length - 1 - i] = 1;
            }
        } else {
            System.out.println("Array has zero size");
        }
        return data;
    }

    private static void printTwoDimensionalArray(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(String.format("%s ", data[i][j]));
            }
            System.out.println("");
        }
    }

    /**
     * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    private static void findMinMax(int[] data) {
        //int[] data = {10, 2, 5, 12, 45, 32, 1, 0, 140};
        int maxVal = data[0];
        int minVal = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > maxVal) {
                maxVal = data[i];
            }
            if (data[i] < minVal) {
                minVal = data[i];
            }
        }

        System.out.println(String.format("Array: %s, MinVal = %s, MaxVal = %s", Arrays.toString(data), minVal, maxVal));
    }

    /**
     * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
     * если в массиве есть место, в котором сумма левой и правой части массива равны.
     * <p>
     * Примеры:
     * checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
     * checkBalance([1, 1, 1, || 2, 1]) → true,
     * <p>
     * граница показана символами ||, эти символы в массив не входят.
     */

    private static boolean checkBalance(int[] data) {
        int leftSum = 0;
        int rightSum = 0;
        for (int border = 1; border < data.length; border++) {
            leftSum = calcSum(data, 0, border - 1);
            rightSum = calcSum(data, border, data.length - 1);
            if (leftSum == rightSum) {
                printBalancedArray(data, border);
                return true;
            }

        }
        System.out.print(Arrays.toString(data));
        return false;
    }

    private static int calcSum(int[] data, int beginPos, int endPos) {
        int result = 0;
        for (int i = beginPos; i <= endPos; i++) {
            result += data[i];
        }
        return result;
    }

    public static void printBalancedArray(int[] data, int border) {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            if (i == border) {
                System.out.print(String.format("|| %s", data[i]));
            } else {
                System.out.print(String.format("%s", data[i]));
            }
            if (i != data.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    /**
     * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
     * или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
     * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     * Примеры:
     * [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
     * [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
     * <p>
     * При каком n в какую сторону сдвиг можете выбирать сами.
     */

    private static void shiftArray(int[] arr, int shiftSize) {
        System.out.print(String.format("%s, shift=%s --> ", Arrays.toString(arr), shiftSize));
        int shiftInc = shiftSize;
        if (Math.abs(shiftSize) > arr.length) {
            shiftInc = Math.abs(shiftSize) % arr.length;
        }
        if (shiftSize < 0) {
            shiftInc = arr.length + (shiftInc * -1);
        }
        for (int i = 0; i < shiftInc; i++) {
            int preValue = arr[0];
            int insertIdx = 1;
            int tmpValue;
            for (int j = 0; j < arr.length; j++) {
                if (insertIdx > arr.length - 1) {
                    insertIdx = 0;
                }
                tmpValue = arr[insertIdx];
                arr[insertIdx] = preValue;
                preValue = tmpValue;
                insertIdx = insertIdx + 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

