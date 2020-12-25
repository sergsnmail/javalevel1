package com.sergsnmail.level1.lesson7;

public class Cat {

    private String name;
    private int appetite;

    /**
     * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
     * Если коту удалось покушать (хватило еды), сытость = true.
     */
    private boolean isFull = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    /**
     * 4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
     * то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
     *
     * @param p тарелка с едой
     */
    public void eat(Plate p) {
        isFull = p.decreaseFood(appetite);
    }

    public boolean isFull() {
        return isFull;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

}
