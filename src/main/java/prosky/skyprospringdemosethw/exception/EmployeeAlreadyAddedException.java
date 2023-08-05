package prosky.skyprospringdemosethw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends HttpStatusCodeException {
    public EmployeeAlreadyAddedException(String message) {
        super(HttpStatus.BAD_REQUEST,message);
    }
}
