package pro.sky.java.course2.weblibrary.Sevices.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.weblibrary.Data.Employee;
import pro.sky.java.course2.weblibrary.Exceptions.BadEmployeeException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    static Employee employee1 = new Employee("Иванов", "Иван", 10, 100);
    static Employee employee2 = new Employee("Вано", "Ваной", 11, 400);
    static Employee employee3 = new Employee("Света", "Ианова", 10, 101);
    static Employee employee4 = new Employee("Анна", "Петрова", 21, 300);

    public static Map<String, Employee> employees = Map.of(
            "Иванов" + "Иван", employee1,
            "Вано" + "Ваной", employee2,
            "Света" + "Ианова", employee3,
            "Анна" + "Петрова", employee4);

    public static Map<String, Employee> employees1 = Map.of(
            "Иванов" + "Иван", employee1,
            "Анна" + "Петрова", employee3);

    public static List<Employee> lstFull = List.of(employee1, employee2, employee3, employee4);

    public static List<Employee> lst = List.of(employee1, employee3);

    @Test
    public void findMaxSalaryEmployeeInDepart() {
        when(employeeServiceMock.showEmployee()).thenReturn(employees);
        Employee getfindMaxSalaryEmployee = out.findMaxSalary(10);
        assertEquals(employee3, getfindMaxSalaryEmployee);
    }


    @Test
    public void findMinSalaryEmployeeInDepart() {
        when(employeeServiceMock.showEmployee()).thenReturn(employees);
        Employee getfindMinSalaryEmployee = out.findMinSalary(10);
        assertEquals(employee1, getfindMinSalaryEmployee);
    }

    @Test
    public void DepartNotExists() {
        when(employeeServiceMock.showEmployee()).thenReturn(employees);
        assertThrows(BadEmployeeException.class, () -> out.findAll(1));
    }


    @Test
    void findAll() {
        when(employeeServiceMock.showEmployee()).thenReturn(employees);
        List<Employee> allEmployeesInDepart = out.findAll(10);
        assertEquals(lst, allEmployeesInDepart);
    }

}