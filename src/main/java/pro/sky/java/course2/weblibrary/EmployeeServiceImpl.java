package pro.sky.java.course2.weblibrary;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private int size;
    private final int countEmployee = 3;
    private final Employee[] employees = new Employee[countEmployee];

    private boolean isNotValue(String a, String b) {
        return (a.isEmpty() || b.isEmpty());
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (isNotValue(firstName, lastName)) {
            throw new badEmployeeException();
        }

        if (size >= employees.length) {
            throw new fullArrayEmployeeException();
        }

        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i] != null) {
                if (employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                    throw new badEmployeeException();
                }
            }
        }

        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                size++;
                System.out.println("Сотрудник " + employees[i].getFirstName() + " " + employees[i].getLastName() + " добавлен.");
                break;
            }
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (isNotValue(firstName, lastName)) {
            throw new badEmployeeException();
        }

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                    employees[i] = null;
                    size--;
                    Employee employee = new Employee(firstName, lastName);
                    System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " удален.");
                    return employee;
                }
            }
        }
        throw new notFindEmployeeException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (isNotValue(firstName, lastName)) {
            throw new badEmployeeException();
        }

        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                    System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " найден.");
                    return employee;
                }
            }
        }
        throw new badEmployeeException();
    }
}
