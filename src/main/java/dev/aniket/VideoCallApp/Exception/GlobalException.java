package dev.aniket.VideoCallApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> userExceptionHandler(UserException userException,
                                                             WebRequest webRequest)
    {
        return new ResponseEntity<>(webRequest.getDescription(true), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNoValidExceptionHandler(MethodArgumentNotValidException argumentNotValidException,
                                                                              WebRequest webRequest)
    {
        return new ResponseEntity<>(webRequest.getDescription(true), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception,
                                                         WebRequest webRequest)
    {
        return new ResponseEntity<>(webRequest.getDescription(true), HttpStatus.BAD_REQUEST);
    }
}
