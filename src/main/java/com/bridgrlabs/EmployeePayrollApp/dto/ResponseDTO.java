package com.bridgrlabs.EmployeePayrollApp.dto;


public class ResponseDTO {
	private String message;
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMsg(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}





	


}
