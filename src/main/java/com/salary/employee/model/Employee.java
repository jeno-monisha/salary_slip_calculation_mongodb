package com.salary.employee.model;

import java.util.Date;
import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee_Data")
public class Employee {
	
	@Id 
	private ObjectId _id;
	private int empId;
	private String designation;
	private Date dateOfJoining;
	private Date retirementDate;
	private Double basicPay;
	private Double da;
	private Double specialAllowance;
	private Double professionalTax;
	private Double pf;
	
	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Date getRetirementDate() {
		return retirementDate;
	}
	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}
	public Double getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(Double basicPay) {
		this.basicPay = basicPay;
	}
	public Double getDa() {
		return da;
	}
	public void setDa(Double da) {
		this.da = da;
	}
	public Double getSpecialAllowance() {
		return specialAllowance;
	}
	public void setSpecialAllowance(Double specialAllowance) {
		this.specialAllowance = specialAllowance;
	}
	public Double getProfessionalTax() {
		return professionalTax;
	}
	public void setProfessionalTax(Double professionalTax) {
		this.professionalTax = professionalTax;
	}
	public Double getPf() {
		return pf;
	}
	public void setPf(Double pf) {
		this.pf = pf;
	}
		
}
