package com.salary.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.salary.employee.model.Employee;
import com.salary.employee.repository.EmployeeRepository;

@SpringBootApplication
public class SalarySlipCalculationApplication {
	
	@Autowired
	  EmployeeRepository employeeRepo;


	public static void main(String[] args) {
		SpringApplication.run(SalarySlipCalculationApplication.class, args);
	}
}
