package com.api.clientpoint.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.clientpoint.Suport.ApiErrors;

import java.util.stream.Collectors;

@RestControllerAdvice
public class AplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleValidationErrors(MethodArgumentNotValidException exception) {
		BindingResult bindingResult = exception.getBindingResult();
		List<String> messages = bindingResult.getAllErrors().stream()
				.map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
		return new ApiErrors(messages);
	}
}
