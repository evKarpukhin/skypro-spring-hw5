package pro.sky.java.course2.weblibrary.Data;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String passNum;

    public Employee(String firstName, String lastName, String passNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passNum = passNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassNum() {
        return passNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && passNum.equals(employee.passNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passNum);
    }

    @Override
    public String toString() {
        return "Сотрудник {" +
                "Фамилия ='" + firstName + '\'' +
                ", Имя='" + lastName + '\'' +
                '}';
    }
}
