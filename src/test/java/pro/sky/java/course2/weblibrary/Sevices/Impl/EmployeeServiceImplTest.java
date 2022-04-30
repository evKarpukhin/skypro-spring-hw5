package pro.sky.java.course2.weblibrary.Sevices.Impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.weblibrary.Data.Employee;
import pro.sky.java.course2.weblibrary.Exceptions.BadEmployeeException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private static final EmployeeService out = new EmployeeServiceImpl();

    static Employee employee1 = new Employee("Иванов", "Иван", 10, 100);
    static Employee employee2 = new Employee("Вано", "Ваной", 11, 200);


    public static Stream<Arguments> provideParametersForTestsDeleteMotExistsEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванов", "Иван", 10, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsDeleteMotExistsEmployee")
    public void checkMethodsDeleteMotExistsEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.addEmployee(firstName, lastName, department, salary));
        assertThrows(BadEmployeeException.class, () -> out.removeEmployee(firstName + "1", lastName, department, salary));
        assertThrows(BadEmployeeException.class, () -> out.removeEmployee(firstName , lastName+"1", department, salary));

    }


    public static Stream<Arguments> provideParametersForTestsDeleteEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванов", "Иван", 10, 100),
                Arguments.of(employee2, "Вано", "Ваной", 11, 200)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsDeleteEmployee")
    public void checkMethodsDeleteEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.addEmployee(firstName, lastName, department, salary));
        assertEquals(empl, out.removeEmployee(firstName, lastName, department, salary));
    }


    public static Stream<Arguments> provideParametersForTestsFindEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванов", "Иван", 10, 100),
                Arguments.of(employee2, "Вано", "Ваной", 11, 200)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsFindEmployee")
    public void checkMethodsFindEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.addEmployee(firstName, lastName, department, salary));
        assertEquals(empl, out.findEmployee(firstName, lastName, department, salary));
    }


    public static Stream<Arguments> provideParametersForTestsAddEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванов", "Иван", 10, 100),
                Arguments.of(employee2, "Вано", "Ваной", 11, 200)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsAddEmployee")
    public void checkMethodsAddEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.addEmployee(firstName, lastName, department, salary));
    }


    public static Stream<Arguments> provideParametersForTestsAddExistsAndWithErrorsEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванов", "Иван", 10, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsAddExistsAndWithErrorsEmployee")
    public void checkMethodsAddExistsEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.addEmployee(firstName, lastName, department, salary));
        assertThrows(BadEmployeeException.class, () -> out.addEmployee("", lastName, department, salary));
        assertThrows(BadEmployeeException.class, () -> out.addEmployee(firstName, "", department, salary));
    }

}