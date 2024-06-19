import java.util.Arrays;

public class Main {
    private final static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Иванов Сергей Петрович", 2, 75_000, 1);
        employees[1] = new Employee("Петрова Анна Ивановна", 1, 63_000, 2);
        employees[2] = new Employee("Степанова Раиса Марковна", 3, 48_000, 3);
        employees[3] = new Employee("Попов Станислав Игоревич", 4, 84_000, 4);
        employees[4] = new Employee("Тихонов Иван Викторович", 5, 52_000, 5);
        employees[5] = new Employee("Карпова Юлия Вкиторовна", 1, 70_000, 6);
        employees[6] = new Employee("Морозов Егор Владиславович", 5, 71_000, 7);
        employees[7] = new Employee("Хохлов Максим Владимирович", 4, 82_000, 8);
        employees[8] = new Employee("Горлова Наталья Константиновна", 2, 47_000, 9);
        employees[9] = new Employee("Астахов Эдуард Венерович", 3, 64_000, 10);

        Employee.printEmployee(employees);
        System.out.println(Arrays.toString(Employee.printEmployee));
    }

}