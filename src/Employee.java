import java.util.Objects;

public class Employee {
    public static long[] printEmployee;
    private static int counter = 1;

    private static String fullName;

    private static int division;

    private static int salaryEmployee;

    private static int id;

    public Employee(String fullName, int division, int salaryEmployee, int id) {
        Employee.fullName = fullName;
        Employee.division = division;
        Employee.salaryEmployee = salaryEmployee;
        Employee.id = counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDivision() {
        return division;
    }

    public int getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setDivision(int division) {
        Employee.division = division;
    }

    public void setSalaryEmployee(int salaryEmployee) {
        Employee.salaryEmployee = salaryEmployee;
    }

    public static String toString(Employee[] employees) {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", division=" + division +
                ", salaryEmployee=" + salaryEmployee +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, division, salaryEmployee, id);
    }

    public static Employee[] printEmployee(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
        return employees;
    }
}
