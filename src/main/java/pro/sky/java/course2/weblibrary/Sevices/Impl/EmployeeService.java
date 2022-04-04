package pro.sky.java.course2.weblibrary.Sevices.Impl;

import pro.sky.java.course2.weblibrary.Data.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastNam);

    Employee removeEmployee(String firstName, String lastNam);

    Employee findEmployee(String firstName, String lastNam);

    List<Employee> showEmployee();

}
