package com.bridgrlabs.EmployeePayrollApp.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

public class EmployeeDTO {
	//@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{4,}$", message = "Employee firstName is Invalid")
	//@NotEmpty(message = "the first name can't be null")
	private String firstName;

	//@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{4,}$", message = "Employee lastName is Invalid")
	//@NotEmpty(message = "the last name can't be null")
	private String lastName;
	
	//@NotEmpty(message = "the profile picture can't be empty")
	private String profilePic;
	
	//@NotEmpty(message = "the department can't be empty")
	private String department;

	//@Min(value = 5000, message = "the minimum wage should be grate then 5000")
	private long salary;
	
	//@NotEmpty(message = "the date  can't be empty")
	private LocalDate date;
	private String notes;
	private String gender;

	// Constructor for the class using  all the fields
	public EmployeeDTO(String firstName, String lastName, String profilePic, String department, long salary,
			LocalDate date, String notes,String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.profilePic = profilePic;
		this.department = department;
		this.salary = salary;
		this.date = date;
		this.notes = notes;
		this.gender=gender;
	}

	
	// Getters and setters for the class fields
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setGender(String gender) {
		this.gender=gender;
	}
	public String getGender() {
		return gender;
	}

}
