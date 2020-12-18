/**
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 */
public class Employee {

    /**
     * ФИО
     */
    private String fio;

    /**
     * Должность
     */
    private String position;

    /**
     * E-mail
     */
    private String email;

    /**
     * Телефон
     */
    private String phone;

    /**
     * Зарплата
     */
    private float salary;

    /**
     * Возраст
     */
    private int age;

    /**
     * 2. Конструктор класса должен заполнять эти поля при создании объекта.
     * @param fio
     * @param position
     * @param email
     * @param phone
     * @param salary
     * @param age
     */
    public Employee(String fio, String position, String email, String phone, float salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    /**
     * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
     */
    public void printInfo() {
        System.out.println("ФИО: " + fio);
        System.out.println("Должность: " + position);
        System.out.println("E-mail: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
