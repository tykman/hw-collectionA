package prosky.skyprospringdemosethw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends HttpStatusCodeException {
    public EmployeeNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND,message);
    }
}
