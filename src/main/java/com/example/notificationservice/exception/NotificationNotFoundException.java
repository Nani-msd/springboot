package com.example.notificationservice.exception;

public class NotificationNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NotificationNotFoundException(String msg) {
		super(msg);
	}

}
