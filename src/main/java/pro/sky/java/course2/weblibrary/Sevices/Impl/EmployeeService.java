package pro.sky.java.course2.weblibrary.Sevices.Impl;

import pro.sky.java.course2.weblibrary.Data.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastNam, String passNum);

    Employee removeEmployee(String firstName, String lastNam, String passNum);

    Employee findEmployee(String firstName, String lastNam, String passNum);

    Map<Employee, String> showEmployee();

}
