package pro.sky.java.course2.weblibrary.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.weblibrary.Data.Employee;
import pro.sky.java.course2.weblibrary.Sevices.Impl.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String welcome() {
        return "Добро пожаловать в БД сотрудников!";
    }

    @GetMapping("/add")
    public Employee add(@RequestParam(value = "firstName") String sf,
                        @RequestParam(value = "lastName") String sl,
                        @RequestParam(value = "department") int department,
                        @RequestParam(value = "salary") int salary) {
        Employee result;
        result = employeeService.addEmployee(sf, sl, department, salary);
        return result;
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(value = "firstName") String sf,
                           @RequestParam(value = "lastName") String sl,
                           @RequestParam(value = "department") int department,
                           @RequestParam(value = "salary") int salary) {
        Employee result;
        result = employeeService.removeEmployee(sf, sl, department, salary);
        return result;
    }

    @GetMapping("/find")
    public Employee find(@RequestParam(value = "firstName") String sf,
                         @RequestParam(value = "lastName") String sl,
                         @RequestParam(value = "department") int department,
                         @RequestParam(value = "salary") int salary) {
        Employee result;
        result = employeeService.findEmployee(sf, sl, department, salary);
        return result;
    }

    // Возвращать сотрудника с максимальной зарплатой на основе номера отдела, который приходит в запрос из браузера.
    @GetMapping("/departments/max-salary")
    public Employee findMaxSalaryInDepartment(@RequestParam(value = "departmentId") int departmentId) {
        Employee result;
        result = employeeService.findMaxSalary(departmentId);
        return result;
    }

    //  Возвращать сотрудника с минимальной зарплатой на основе номера отдела.
    @GetMapping("/departments/min-salary")
    public Employee findMinSalaryInDepartment(@RequestParam(value = "departmentId") int departmentId) {
        Employee result;
        result = employeeService.findMinSalary(departmentId);
        return result;
    }

    // Возвращать всех сотрудников по отделу.
    @GetMapping("/departments/all")
    public List<Employee> findAllInDepartment(@RequestParam(value = "departmentId") int departmentId) {
        List<Employee> result;
        result = employeeService.findAll(departmentId);
        return result;
    }

    // Возвращать всех сотрудников с разделением по отделам.
    @GetMapping("/departments/alls")
    public List<Employee> findAll() {
        List<Employee> result;
        result = employeeService.findAllEmployee();
        return result;
    }

    @GetMapping("/showall")
    public Map<String, Employee> showAll() {
        Map<String, Employee> result;
        result = employeeService.showEmployee();
        return result;
    }

}
