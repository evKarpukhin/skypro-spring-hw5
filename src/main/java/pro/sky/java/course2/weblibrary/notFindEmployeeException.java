package pro.sky.java.course2.weblibrary;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class notFindEmployeeException extends RuntimeException {
    // Возвращает статус 404 Not Found.
}
