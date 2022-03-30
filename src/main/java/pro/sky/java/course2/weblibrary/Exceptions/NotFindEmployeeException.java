package pro.sky.java.course2.weblibrary.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFindEmployeeException extends RuntimeException {
    // Возвращает статус 404 Not Found.
}
