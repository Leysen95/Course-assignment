public class Main {
    public static Employee[] employees;
    private static Employee[] employeesInDivision;

    public Main() {
        employees = new Employee[10];
        initializeEmployees();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printEmployee();
        System.out.println("Общая сумма затрат на заработную плату в месяц: " + main.getSumSalary());
        System.out.println("Сотрудник с минимальной зработной платой: " + main.getEmployeeWithMinSalary(employeesInDivision));
        System.out.println("Сотрудник с максимальной заработной платой: " + main.getEmployeeWithMaxSalary(employeesInDivision));
        System.out.println("Средняя заработная плата в месяц: " + main.getMonthlyAverageSalary(employeesInDivision));
        System.out.println("Список сотрудников: ");
        main.printEmployeesFullNames();

        indexSalaries(employees, 15);
        printEmployee();
        System.out.println("Сотрудник с минимальной зарплатой в отделе 5: " + getMinSalaryEmployeeInDivision(employees, 5));
        System.out.println("Сотрудник с максимальной зарплатой в отделе 3: " + getMaxSalaryEmployeeInDivision(employees, 3));
        System.out.println("Средняя заработная плата по отделу 4: " + getAverageSalaryInDivision(employees, 4));

        indexSalariesInDivision(employees, 2, 5);
        System.out.println("Отдел 2 после индексации на 5 процентов: ");
        printEmployeesInDivision(employees, 2);
        System.out.println("Сотрудник с заработной платой меньше 60_000:");
        main.printEmployee(getEmployeesWithLowerSalary(employees, 60_000));
        System.out.println("Сотрудник с заработной платой больше или равной 70_000");
        main.printEmployee1(getEmployeesWithHigherSalary(employees, 70_000));


    }

    public static void initializeEmployees() {
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

    public static void printEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int getSumSalary() {
        int sumSalary = 0;
        for (Employee employee : employees) {
            sumSalary += employee.getSalary();
        }
        return sumSalary;
    }

    public static Employee getEmployeeWithMinSalary(Employee[] employeesInDivision) {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public static Employee getEmployeeWithMaxSalary(Employee[] employeesInDivision) {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public static double getMonthlyAverageSalary(Employee[] employeesInDivision) {
        double monthlyAverageSalary = (double) getSumSalary() / employees.length;
        return monthlyAverageSalary;
    }

    public void printEmployeesFullNames() {
        int idCount = 1;
        for (Employee employee : employees) {
            System.out.printf("%d. %s%n", idCount, employee.getFullName());
            idCount++;
        }
    }

    public static int getEmployeesCount(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum++;
            }
        }
        return sum;
    }

    public static void indexSalaries(Employee[] employees, int percent) {
        if (percent <= 0) {
            throw new IllegalArgumentException("Процент не может быть отрицательным или равным 0");
        }
        for (int i = 0; i < getEmployeesCount(employees); i++) {
            int increasedSalary = (int) (employees[i].getSalary() + (double) employees[i].getSalary() * percent / 100);
            employees[i].setSalary(increasedSalary);
        }
    }

    public static Employee getMinSalaryEmployeeInDivision(Employee[] employees, int division) {
        Employee[] employeesInDivision = getEmployeesInDivision(employees, division);
        return getEmployeeWithMinSalary(employeesInDivision);
    }

    public static Employee getMaxSalaryEmployeeInDivision(Employee[] employees, int division) {
        Employee[] employeesInDivision = getEmployeesInDivision(employees, division);
        return getEmployeeWithMaxSalary(employeesInDivision);
    }

    public static Employee[] getEmployeesInDivision(Employee[] employees, int division) {
        Employee[] employeesInDivision = new Employee[getEmployeesCount(employees)];
        for (int i = 0, k = 0; i < employeesInDivision.length; i++) {
            if (division == employees[i].getDivision()) {
                employeesInDivision[k] = employees[i];
                k++;
            }
        }
        return employeesInDivision;
    }

    public static void printEmployeesInDivision(Employee[] employees, int division) {
        Employee[] employeesInDivision = getEmployeesInDivision(employees, division);
        for (int i = 0; i < getEmployeesCount(employeesInDivision); i++) {
            String string = String.format("%s, id: %s, зарплата: %s", employeesInDivision[i].getFullName(), employeesInDivision[i].getId(), employeesInDivision[i].getSalary());
            System.out.println(string);
        }
    }

    public static double getAverageSalaryInDivision(Employee[] employees, int division) {
        Employee[] employeesInDivision = getEmployeesInDivision(employees, division);
        return getMonthlyAverageSalary(employeesInDivision);
    }

    public static void indexSalariesInDivision(Employee[] employees, int division, int percent) {
        if (percent <= 0) {
            throw new IllegalArgumentException("Процент не может быть отрицательным и равным 0");
        }
        Employee[] employeesInDivision = getEmployeesInDivision(employees, division);
        indexSalaries(employeesInDivision, percent);
    }

    public static Employee[] getEmployeesWithLowerSalary(Employee[] employees, int targetSalary) {
        Employee[] employeesTarget = new Employee[getEmployeesCount(employees)];
        int counter = 0;
        for (int i = 0; i < employeesTarget.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < targetSalary) {
                employeesTarget[counter++] = employees[i];
            }
        }
        return employeesTarget;
    }

    private void printEmployee(Employee[] employeesWithLowerSalary) {
        for (Employee employee : employeesWithLowerSalary) {
            if (employee != null) {
                System.out.println("ID: " + employee.getSalary());
                System.out.println("ФИО: " + employee.getFullName());
                System.out.println("Заработная плата: " + employee.getSalary());
                System.out.println();
            }
        }
    }

    public static Employee[] getEmployeesWithHigherSalary(Employee[] employees, int targetSalary) {
        Employee[] employeesTarget = new Employee[getEmployeesCount(employees)];
        int counter = 0;
        for (int i = 0; i < employeesTarget.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= targetSalary) {
                employeesTarget[counter++] = employees[i];
            }
        }
        return employeesTarget;
    }

    private void printEmployee1(Employee[] employeesWithHigherSalary) {
        for (Employee employee : employeesWithHigherSalary) {
            if (employee != null) {
                System.out.println("ID: " + employee.getSalary());
                System.out.println("ФИО: " + employee.getFullName());
                System.out.println("Заработная плата: " + employee.getSalary());
                System.out.println();
            }
        }
    }
}
