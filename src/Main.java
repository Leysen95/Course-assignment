public class Main {
    public Employee[] employees;

    public Main() {
        employees = new Employee[10];
        initializeEmployees();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printEmployee();
        System.out.println("Общая сумма затрат на заработную плату в месяц: " + main.getSumSalary());
        System.out.println("Сотрудник с минимальной зработной платой: " + main.getEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной заработной платой: " + main.getEmployeeWithMaxSalary());
        System.out.println("Средняя заработная плата в месяц: " + main.getMonthlyAverageSalary());
        System.out.println("Список сотрудников: ");
        main.printEmployeesFullNames();
    }

    public void initializeEmployees() {
        employees[0] = new Employee("Иванов Сергей Петрович", 2, 75_000);
        employees[1] = new Employee("Петрова Анна Ивановна", 1, 63_000);
        employees[2] = new Employee("Степанова Раиса Марковна", 3, 48_000);
        employees[3] = new Employee("Попов Станислав Игоревич", 4, 84_000);
        employees[4] = new Employee("Тихонов Иван Викторович", 5, 52_000);
        employees[5] = new Employee("Карпова Юлия Вкиторовна", 1, 70_000);
        employees[6] = new Employee("Морозов Егор Владиславович", 5, 71_000);
        employees[7] = new Employee("Хохлов Максим Владимирович", 4, 82_000);
        employees[8] = new Employee("Горлова Наталья Константиновна", 2, 47_000);
        employees[9] = new Employee("Астахов Эдуард Венерович", 3, 64_000);
    }

    public void printEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public int getSumSalary() {
        int sumSalary = 0;
        for (Employee employee : employees) {
            sumSalary += employee.getSalary();
        }
        return sumSalary;
    }

    public Employee getEmployeeWithMinSalary() {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee getEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public double getMonthlyAverageSalary() {
        double monthlyAverageSalary = (double) getSumSalary() / employees.length;
        return monthlyAverageSalary;
    }
    public void printEmployeesFullNames(){
        int idCount = 1;
        for (Employee employee : employees) {
            System.out.printf("%d. %s%n", idCount, employee.getFullName());
            idCount++;
        }
    }
}
