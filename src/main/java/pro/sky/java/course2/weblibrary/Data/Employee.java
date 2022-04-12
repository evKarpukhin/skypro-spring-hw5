package pro.sky.java.course2.weblibrary.Data;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int department;
    private final int salary;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }

    @Override
    public String toString() {
        return "Сотрудник {" +
                "Фамилия='" + firstName + '\'' +
                ", Имя='" + lastName + '\'' +
                ", Отдел =" + department +
                ", ЗарПлата=" + salary +
                '}';
    }
}
