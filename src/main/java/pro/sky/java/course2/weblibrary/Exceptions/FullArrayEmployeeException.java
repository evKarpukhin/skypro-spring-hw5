package pro.sky.java.course2.weblibrary.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FullArrayEmployeeException extends RuntimeException {
    // Возвращает статус 500 Internal Server Error.
}
