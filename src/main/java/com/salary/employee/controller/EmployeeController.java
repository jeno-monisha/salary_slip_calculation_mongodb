package com.salary.employee.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salary.employee.model.Employee;
import com.salary.employee.repository.EmployeeRepository;
import com.salary.employee.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

	@GetMapping(value = "/")
	public List<Employee> getAllEmployees() {		
		return employeeRepository.findAll();
	}
	
	@GetMapping(value = "/byEmpId/{empId}")
	public Employee getEmployeeByEmpId(@PathVariable("empId") int empId) {
		return employeeRepository.findByEmpId(empId);
	}
	
	@GetMapping(value = "/byDesignation/{designation}")
	public Employee getEmployeeByDesignation(@PathVariable("designation") String designation) {
		return employeeRepository.findByDesignation(designation);
	}
	
	@GetMapping(value = "/orderByDa")
	public List<Employee> findAllByOrderByDaDesc() {
		return employeeRepository.findAllByOrderByDa();
	}
	
	@PostMapping(value = "/save")
	public Employee saveEmployee(@RequestBody Employee employee) {	 
	    employee.set_id(ObjectId.get());
	    employee.setEmpId(employee.get_id().hashCode());
    	employeeRepository.save(employee);
    	return employee;
	}
	
	@DeleteMapping(value = "/delete/{empId}")
	public void deleteEmployee(@PathVariable String empId) {
		employeeRepository.deleteById(empId);
	}
}
