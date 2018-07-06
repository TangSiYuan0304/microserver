package com.pktech.service.impl.ex;

public class UserNameAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2060881624986046673L;
	
	
	public UserNameAlreadyExistException(){
		
	}
	public UserNameAlreadyExistException(String msg){
		super(msg);
	}

}
