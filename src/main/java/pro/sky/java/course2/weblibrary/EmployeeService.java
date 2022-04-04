package pro.sky.java.course2.weblibrary;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastNam);

    Employee removeEmployee(String firstName, String lastNam);

    Employee findEmployee(String firstName, String lastNam);

}
