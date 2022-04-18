package pro.sky.java.course2.weblibrary.Sevices.Impl;

import pro.sky.java.course2.weblibrary.Data.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastNam, int department, int salary);

    Employee removeEmployee(String firstName, String lastNam, int department, int salary);

    Employee findEmployee(String firstName, String lastNam, int department, int salary);

    Map<String, Employee> showEmployee();

    Employee findMaxSalary(int departmentId);

    Employee findMinSalary(int departmentId);

    List<Employee> findAll(int departmentId);

    List<Employee>  findAllEmployee();
}
