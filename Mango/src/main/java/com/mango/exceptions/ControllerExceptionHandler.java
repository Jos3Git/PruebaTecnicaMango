package com.mango.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ErrorMessage> illegalArgumentException(IllegalArgumentException ex) throws Exception {
        ErrorMessage message= ErrorMessage.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.toString())
                .date(LocalDateTime.now())
                .build();

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserNotFoundRuntimeException.class})
    public ResponseEntity<ErrorMessage> userNotFoundRuntimeException(UserNotFoundRuntimeException ex) {
		ErrorMessage message = ErrorMessage.builder()
			.message(ex.getMessage())
			.status(HttpStatus.NOT_FOUND.toString())
			.date(LocalDateTime.now())
			.build();

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {SloganNotFoundRuntimeException.class})
	public ResponseEntity<ErrorMessage> sloganNotFoundRuntimeException(SloganNotFoundRuntimeException ex) {
		ErrorMessage message= ErrorMessage.builder()
			.message(ex.getMessage())
			.status(HttpStatus.NOT_FOUND.toString())
			.date(LocalDateTime.now())
			.build();

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {TooMuchSlogansRuntimeException.class})
	public ResponseEntity<ErrorMessage> tooMuchSlogansRuntimeException(TooMuchSlogansRuntimeException ex) {
		ErrorMessage message= ErrorMessage.builder()
			.message(ex.getMessage())
			.status(HttpStatus.NOT_ACCEPTABLE.toString())
			.date(LocalDateTime.now())
			.build();

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_ACCEPTABLE);
	}

}
