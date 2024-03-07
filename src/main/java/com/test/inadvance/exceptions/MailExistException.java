package com.test.inadvance.exceptions;

public class MailExistException extends RuntimeException{
	
	private static final String MAIL_EXISTS = "Mail exists";
	
    public MailExistException(String message) {
        super(MAIL_EXISTS + " " + message);
    }

}
