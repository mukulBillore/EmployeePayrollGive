package com.bridgrlabs.EmployeePayrollApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgrlabs.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgrlabs.EmployeePayrollApp.dto.ResponseDTO;
import com.bridgrlabs.EmployeePayrollApp.model.EmployeeModel;
import com.bridgrlabs.EmployeePayrollApp.service.EmployeeService;

import lombok.Data;

@RestController
@RequestMapping("/employPayrollApp")
@CrossOrigin
public @Data class EmployeeController {
	@Autowired
	EmployeeService service;

	// Showing hello message with no name
	@GetMapping("/")
	public String test() {
		return "hello dear ! welcome to employ paroll app ";
	}

	// Showing hello message  by name of entered name
	@PutMapping("/hello")
	public ResponseEntity<String> sayHelloToUserByName(@RequestParam String fname) {
		String msg = "Hello " + service.getUserName(fname) + "  to EmployParollApp";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	// Saving the employ data using dto layer
	@PostMapping("/save")
	public ResponseEntity<String> saveUserdatabyDTO(@Valid @RequestBody EmployeeDTO employeedto) {
		EmployeeModel employeeModel = service.saveEmployDTO(employeedto);
		ResponseDTO responsedto = new ResponseDTO("sucussfully saved employee", employeeModel);
		return new ResponseEntity(responsedto, HttpStatus.OK);
	}

	// Getting the employ data by id
	@GetMapping("/getById/{id}")
		public ResponseEntity<EmployeeModel> retriveUserdataById(@PathVariable Integer id) {
		EmployeeModel employeeModel = service.getEmploy(id);
		return new ResponseEntity<EmployeeModel>(employeeModel, HttpStatus.OK);
	}

	// Update the employ by id through dto layer
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateUserdataByIdUsingDTO(@RequestBody EmployeeDTO employeeDTO,
			@PathVariable Integer id) {
		EmployeeModel employeeModel = service.updateUserThroughDTOByID(id, employeeDTO);
		ResponseDTO responsedto = new ResponseDTO("updated sucussFully", employeeModel);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	// Get-all employee data which is saved in database
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeModel>> getAllDataFromRepo() {
		return new ResponseEntity<List<EmployeeModel>>(service.getAllData(), HttpStatus.OK);
	}

	// Delete the employ by id from database
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteUserdataById(@PathVariable Integer id) {
		String employee =service.deleteEmployById(id);
		ResponseDTO responsedto = new ResponseDTO("delete sucussFully", employee);
		return new ResponseEntity<ResponseDTO>(responsedto,HttpStatus.OK);
	}

	// For custom query
	@GetMapping("/customFind")
	public EmployeeModel finddeptWiseRecord(@RequestParam String dept) {
		EmployeeModel employees = service.findDept(dept);
		return employees;
	}

}
