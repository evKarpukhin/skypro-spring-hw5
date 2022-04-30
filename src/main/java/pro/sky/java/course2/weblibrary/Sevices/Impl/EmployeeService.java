package pro.sky.java.course2.weblibrary.Sevices.Impl;

import pro.sky.java.course2.weblibrary.Data.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastNam, int department, int salary);

    Employee removeEmployee(String firstName, String lastNam, int department, int salary);

    Employee findEmployee(String firstName, String lastNam, int department, int salary);

    Map<String, Employee> showEmployee();

}
