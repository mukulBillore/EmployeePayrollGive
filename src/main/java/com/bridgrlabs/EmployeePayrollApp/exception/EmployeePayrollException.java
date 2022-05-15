package com.bridgrlabs.EmployeePayrollApp.exception;

public class EmployeePayrollException extends RuntimeException {

	// constructor for the class passing userFriendly error msg
	public EmployeePayrollException(String message) {
		super(message);
	}
}
