package pro.sky.java.course2.weblibrary.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadEmployeeException extends RuntimeException {
    // Возвращает статус 400 Bad Request.
}
