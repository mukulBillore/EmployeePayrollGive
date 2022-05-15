package com.bridgrlabs.EmployeePayrollApp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgrlabs.EmployeePayrollApp.dto.EmployeeDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name="test")
public class EmployeeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private String profilePic;
	private String department;
	private String gender;
	private long salary;
	private LocalDate date;
	private String notes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public EmployeeModel(Integer id, String firstName, String lastName, String profilePic, String department,
			String gender, long salary, LocalDate date, String notes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profilePic = profilePic;
		this.department = department;
		this.gender = gender;
		this.salary = salary;
		this.date = date;
		this.notes = notes;
	}
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeModel(EmployeeDTO employeeDTO) {
		this.firstName = employeeDTO.getFirstName();
		this.lastName = employeeDTO.getLastName();
		this.profilePic = employeeDTO.getProfilePic();
		this.department = employeeDTO.getDepartment();
		this.gender = employeeDTO.getGender();
		this.salary = employeeDTO.getSalary();
		this.date = employeeDTO.getDate();
		this.notes = employeeDTO.getNotes();
}
	public EmployeeModel(Integer id2, EmployeeDTO employeeDTO) {
		this.id=id2;
		this.firstName = employeeDTO.getFirstName();
		this.lastName = employeeDTO.getLastName();
		this.profilePic = employeeDTO.getProfilePic();
		this.department = employeeDTO.getDepartment();
		this.gender = employeeDTO.getGender();
		this.salary = employeeDTO.getSalary();
		this.date = employeeDTO.getDate();
		this.notes = employeeDTO.getNotes();
}
	
	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", profilePic="
				+ profilePic + ", department=" + department + ", gender=" + gender + ", salary=" + salary + ", date="
				+ date + ", notes=" + notes + "]";
	}

	
	


}