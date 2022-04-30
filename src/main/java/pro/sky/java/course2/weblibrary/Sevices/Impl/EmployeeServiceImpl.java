package pro.sky.java.course2.weblibrary.Sevices.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.weblibrary.Data.Employee;
import pro.sky.java.course2.weblibrary.Exceptions.BadEmployeeException;
import pro.sky.java.course2.weblibrary.Exceptions.NotFindEmployeeException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>(10, 0.75f);

    private boolean checkValues(String a, String b) {
        return !(StringUtils.isAlpha(a) && StringUtils.isAlpha(b));
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        if (checkValues(firstName, lastName)) {
            throw new BadEmployeeException();
        }

        String firstName1 = StringUtils.capitalize(firstName);
        String lastName1 = StringUtils.capitalize(lastName);

        Employee employee = new Employee(firstName1, lastName1, department, salary);
        if (employees.containsKey(firstName1 + lastName1)) {
            throw new BadEmployeeException();
        }

        employees.put(firstName1 + lastName1, employee);
        System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " " + " добавлен.");
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, int salary) {
        if (checkValues(firstName, lastName)) {
            throw new BadEmployeeException();
        }

        String firstName1 = StringUtils.capitalize(firstName);
        String lastName1 = StringUtils.capitalize(lastName);

        Employee employee = new Employee(firstName1, lastName1, department, salary);
        if (employees.containsKey((firstName1 + lastName1))) {
            employees.remove(firstName1 + lastName1);
            System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " " + " удален.");
            return employee;
        }
        throw new NotFindEmployeeException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int department, int salary) {
        if (checkValues(firstName, lastName)) {
            throw new BadEmployeeException();
        }

        String firstName1 = StringUtils.capitalize(firstName);
        String lastName1 = StringUtils.capitalize(lastName);

        Employee employee = new Employee(firstName1, lastName1, department, salary);
        if (employees.containsKey(firstName1 + lastName1)) {
            System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " " + " найден.");
            return employee;
        }
        throw new BadEmployeeException();
    }

    @Override
    public Map<String, Employee> showEmployee() {
        return employees;
    }

}
