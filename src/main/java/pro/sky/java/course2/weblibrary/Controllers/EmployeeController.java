package pro.sky.java.course2.weblibrary.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.weblibrary.Data.Employee;
import pro.sky.java.course2.weblibrary.Sevices.Impl.EmployeeService;

import java.util.List;

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
    public Employee add(@RequestParam(value = "firstName") String sf, @RequestParam(value = "lastName") String sl) {
        Employee result;
        result = employeeService.addEmployee(sf, sl);
        return result;
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(value = "firstName") String sf, @RequestParam(value = "lastName") String sl) {
        Employee result;
        result = employeeService.removeEmployee(sf, sl);
        return result;
    }

    @GetMapping("/find")
    public Employee find(@RequestParam(value = "firstName") String sf, @RequestParam(value = "lastName") String sl) {
        Employee result;
        result = employeeService.findEmployee(sf, sl);
        return result;
    }

    @GetMapping("/showall")
    public List<Employee> showall() {
        List<Employee> result;
        result = employeeService.showEmployee();
        return result;
    }

}
