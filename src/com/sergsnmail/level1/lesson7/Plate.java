package com.sergsnmail.level1.lesson7;

public class Plate {

    private int foodQuantity;

    public Plate(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    /**
     * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
     * (например, в миске 10 еды, а кот пытается покушать 15-20).
     *
     * 4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
     * то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
     *
     * @param n количество еды съедаемой из тарелки
     * @return false если не удалось поесть, иначе true
     */
    public boolean decreaseFood(int n) {
        if (n > foodQuantity) {
            return false;
        }
        foodQuantity -= n;
        return true;
    }

    /**
     * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
     * @param n
     */
    public void increaseFood(int n) {
        foodQuantity += n;
    }

    public void info() {
        System.out.println("Food quantity in plate: " + foodQuantity);
    }
}
