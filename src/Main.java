public class Main {
    public static void main(String[] args) {

        /**
         * 4. Создать массив из 5 сотрудников.
         */
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan Ivanovich", "Software Engineer", "ivaniv-ii@maibox.com", "+7(894)5612332", 70000, 30);
        employees[1] = new Employee("Petrov Petr Petrovich", "Senior Software Engineer", "petrov-pp@maibox.com", "+7(968)5896432", 150000, 44);
        employees[2] = new Employee("Jukov Oleg Ivanovich", "Tech Lead", "jukov-oi@maibox.com", "+7(546)2541986", 200000, 41);
        employees[3] = new Employee("Sidorov Andrey Olegovich", "Software Engineer", "sidorov-ao@maibox.com", "+7(532)6782165", 85000, 36);
        employees[4] = new Employee("Zotov Mikhail Yurevich", "Senior Software Engineer", "zotov-my@maibox.com", "+7(478)3658974", 150000, 39);

        /**
         * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
         */
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                System.out.println();
                employees[i].printInfo();
            }
        }
    }
}
