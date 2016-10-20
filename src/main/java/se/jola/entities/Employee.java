package se.jola.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private String employeeNumber;
    
    @ManyToOne
    private Department department;
    
    @Embedded
    private ParkingSpace parkingSpace;
    
    
    
    protected Employee(){}
    
    public Employee(String firstName, String lastName, String employeeNumber) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.employeeNumber = employeeNumber;
    }
    
    public String getFirstName() {
	return firstName;
    }
    
    public String getLastName() {
	return lastName;
    }
    
    public String getEmployeeNumber() {
	return employeeNumber;
    }
    
    public Long getId() {
	return id;
    }
    
    public Employee setFirstName(String firstName) {
	this.firstName = firstName;
	
	return this;
    }
    
    public Employee setLastName(String lastName) {
	this.lastName = lastName;
	
	return this;
    }
    
    public Employee setParkingSpace(ParkingSpace parkingSpace) {
	this.parkingSpace = parkingSpace;
	
	return this;
    }
    
    public Employee setDepartment(Department department){
	this.department = department;
	
	return this;
    }

}
