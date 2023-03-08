package com.salary.employee.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.salary.employee.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{
	
	Employee findByEmpId(int empId);

	Employee findByDesignation(String designation);

	List<Employee> findAllByOrderByDa();
	

}
