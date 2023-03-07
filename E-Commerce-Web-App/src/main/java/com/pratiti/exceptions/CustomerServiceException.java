package com.pratiti.exceptions;

@SuppressWarnings("serial")
public class CustomerServiceException extends RuntimeException {
    
	private String email;
	private String msg;
	
	public CustomerServiceException(String msg, String email) {
		this.email = email;
		this.msg = msg + email;
	}
	
	public CustomerServiceException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getId() {
		return email;
	}
	public void setId(String id) {
		this.email = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	     
		
}
