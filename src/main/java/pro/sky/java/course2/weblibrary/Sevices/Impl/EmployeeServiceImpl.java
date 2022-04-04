package pro.sky.java.course2.weblibrary.Sevices.Impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.weblibrary.Data.Employee;
import pro.sky.java.course2.weblibrary.Exceptions.BadEmployeeException;
import pro.sky.java.course2.weblibrary.Exceptions.NotFindEmployeeException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>(5);

    private boolean isNotValue(String a, String b) {
        return (a.isEmpty() || b.isEmpty());
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (isNotValue(firstName, lastName)) {
            throw new BadEmployeeException();
        }

        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new BadEmployeeException();
        }

        employees.add(employee);
        System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " добавлен.");
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (isNotValue(firstName, lastName)) {
            throw new BadEmployeeException();
        }

        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            if (employees.remove(employee)) {
                System.out.println("Сотрудник " + firstName + " " + lastName + " удален.");
                return employee;
            }
        }
        throw new NotFindEmployeeException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (isNotValue(firstName, lastName)) {
            throw new BadEmployeeException();
        }

        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            System.out.println("Сотрудник " + firstName + " " + lastName + " найден.");
            return employee;
        }
        throw new BadEmployeeException();
    }

    @Override
    public List<Employee> showEmployee() {
        return employees;
    }

}
