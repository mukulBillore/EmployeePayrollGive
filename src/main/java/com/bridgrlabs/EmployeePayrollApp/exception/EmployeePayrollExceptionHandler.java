package com.bridgrlabs.EmployeePayrollApp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgrlabs.EmployeePayrollApp.dto.ResponseDTO;

@ControllerAdvice
public class EmployeePayrollExceptionHandler {
	// handles  the exception when the regex fails 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {

		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());

		ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST requests", errMsg);
		ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity<ResponseDTO>(responseDTO,
				HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	// handles the exceptions of when the "EmployeePayrollException" is throws down .
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeeNotFound(EmployeePayrollException exception) {
		ResponseDTO responsedto = new ResponseDTO("Invalid id input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.BAD_REQUEST);
	}
}