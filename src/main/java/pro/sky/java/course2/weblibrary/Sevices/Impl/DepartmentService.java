package pro.sky.java.course2.weblibrary.Sevices.Impl;

import pro.sky.java.course2.weblibrary.Data.Employee;

import java.util.List;

public interface DepartmentService {

    Employee findMaxSalary(int departmentId);

    Employee findMinSalary(int departmentId);

    List<Employee> findAll(int departmentId);

    List<Employee> findAllEmployee();

}
