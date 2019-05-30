package io.github.rocketzera.cleanarchitecture.usecase.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.rocketzera.cleanarchitecture.usecase.exception.ApplicationException;

@RestControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, String> handleApplicationException(ApplicationException ex) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "Application error.");
	    return errorResponse;
	}
}
