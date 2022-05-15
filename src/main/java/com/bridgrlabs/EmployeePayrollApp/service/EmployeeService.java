package com.bridgrlabs.EmployeePayrollApp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgrlabs.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgrlabs.EmployeePayrollApp.exception.EmployeePayrollException;
import com.bridgrlabs.EmployeePayrollApp.model.EmployeeModel;
import com.bridgrlabs.EmployeePayrollApp.repository.EmployeePayrollRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeePayrollRepo repo;

	// Get employee name
	public String getUserName(String fname) {
		EmployeeModel employee = new EmployeeModel();
		employee.setFirstName(fname);
		return employee.getFirstName();
	}



	// Saving the data through DTO
	public EmployeeModel saveEmployDTO(EmployeeDTO employeeDTO) {
		EmployeeModel emoloyee = new EmployeeModel(employeeDTO);
		repo.save(emoloyee);
		//System.out.println(emoloyee.toString());
		
		return emoloyee;
	}

	// Find specific employee by id
	public EmployeeModel getEmploy(Integer id) {
		Optional<EmployeeModel> employee = repo.findById(id);
		if (employee.isEmpty()) {
			throw new EmployeePayrollException("id not found");
		}
		return employee.get();
	}

	// Get list of all the employ
	public List<EmployeeModel> getAllData() {
		List<EmployeeModel> list = repo.findAll();
		return list;

	}

//	// Update specific by id
//	public EmployeeModel updateEmploy(Integer id, EmployeeModel employee) {
//		Optional<EmployeeModel> employee1 = repo.findById(id);
//		EmployeeModel emp;
//
//		if (employee1.isEmpty()) {
//			throw new EmployeePayrollException("employee with id not found so cant update");
//		} else {
//			emp = new EmployeeModel(id, employee);
//
//			repo.save(emp);
//		}
//		return emp;
//	}


	// Update through dto
	public EmployeeModel updateUserThroughDTOByID(Integer id, EmployeeDTO employee) {
		EmployeeModel newEmp = new EmployeeModel(id, employee);
		repo.save(newEmp);
		return newEmp;
	}

	// Delete employee by id
	public String deleteEmployById(Integer id) {
		Optional<EmployeeModel> employee = repo.findById(id);
		if (employee.isEmpty()) {
			throw new EmployeePayrollException("employee not persent to delete");
		}else {
			
		

		repo.deleteById(id);
	
		return "sucussed in deleting the employ";
		}
		}

	// Custom created dept query
	public EmployeeModel findDept(String dept) {
		
		return null;
	}

	
}
