package com.example.notificationservice.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.notificationservice.exception.NotificationNotFoundException;

@RestControllerAdvice
public class NotFoundExceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(com.example.notificationservice.exception.NotificationNotFoundException.class)
	public Map<String,String> HandleNotificationNotFoundException(NotificationNotFoundException ex){
		Map<String,String> err=new HashMap<String, String>();
		err.put("error message", ex.getMessage());
		return err;
	}
	
}
