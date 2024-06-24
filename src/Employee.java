import java.util.Objects;

public class Employee {

    private final String fullName;

    private int salary;

    private int division;

    private final int id;

    private static int idCount = 1;

    public Employee(String fullName, int division, int salary) {
        this.fullName = fullName;
        this.division = validateDivision(division);
        this.salary = validateSalary(salary);
        this.id = idCount++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = validateSalary(salary);
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = validateDivision(division);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", division=" + division +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                division == employee.division &&
                id == employee.id &&
                Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, division, id);
    }

    private int validateSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Заработная плата не может быть отрицательной");
        }
        return salary;
    }

    private int validateDivision(int division) {
        if (division < 1 || division > 5) {
            throw new IllegalArgumentException("Номер отдела недопустим.");
        }
        return division;
    }
}
