package pro.sky.java.course2.weblibrary.Sevices.Impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.weblibrary.Data.Employee;
import pro.sky.java.course2.weblibrary.Exceptions.BadEmployeeException;
import pro.sky.java.course2.weblibrary.Exceptions.NotFindEmployeeException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Employee, String> employees = new HashMap<>(5, 0.75f);

    private boolean isNotValue(String a, String b, String c) {
        return (a.isEmpty() || b.isEmpty() || c.isEmpty() );
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, String passNum) {
        if (isNotValue(firstName, lastName, passNum)) {
            throw new BadEmployeeException();
        }

        Employee employee = new Employee(firstName, lastName, passNum);
        if (employees.containsKey(employee)) {
            throw new BadEmployeeException();
        }

        employees.put(employee, passNum);
        System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPassNum() + " добавлен.");
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, String passNum) {
        if (isNotValue(firstName, lastName, passNum)) {
            throw new BadEmployeeException();
        }

        Employee employee = new Employee(firstName, lastName, passNum);
        if (employees.containsKey((employee))) {
            employees.remove(employee);
            System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPassNum() + " удален.");
            return employee;
        }
        throw new NotFindEmployeeException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, String passNum) {
        if (isNotValue(firstName, lastName, passNum)) {
            throw new BadEmployeeException();
        }

        Employee employee = new Employee(firstName, lastName, passNum);
        if (employees.containsKey(employee)) {
            System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPassNum() + " найден.");
            return employee;
        }
        throw new BadEmployeeException();
    }

    @Override
    public Map<Employee, String> showEmployee() {
        return employees;
    }

}
