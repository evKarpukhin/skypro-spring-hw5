package pro.sky.java.course2.weblibrary.Sevices.Impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.weblibrary.Data.Employee;
import pro.sky.java.course2.weblibrary.Exceptions.BadEmployeeException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalary(int departmentId) {
        Optional<Employee> emp;
        emp = employeeService.showEmployee().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary));
        return emp.orElseThrow(() -> new RuntimeException("Не найден сотрудник с максимальной З/п для отдела " + departmentId + " !"));
    }

    @Override
    public Employee findMinSalary(int departmentId) {
        Optional<Employee> emp;
        emp = employeeService.showEmployee().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary));
        return emp.orElseThrow(() -> new RuntimeException("Не найден сотрудник с минимальной З/п для отдела " + departmentId + " !"));
    }

    @Override
    public List<Employee> findAll(int departmentId) {
        List<Employee> empList;
        empList = employeeService.showEmployee().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
        if (empList.isEmpty()) {
            throw new BadEmployeeException("Не найден сотрудник из отдела " + departmentId + " !");
        } else
        return empList;
    }

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> result = new ArrayList<>();
        Set<Integer> depList = employeeService.showEmployee().values().stream()
                .map(Employee::getDepartment)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (Integer dep : depList) {
            result.addAll(findAll(dep));
        }
        return result;
    }

}
