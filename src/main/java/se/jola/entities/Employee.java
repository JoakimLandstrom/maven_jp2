package se.jola.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    
    @OneToOne
    @JoinColumn(unique = true)
    private ParkingSpace parkingSpace;
    
    protected Employee(){}
    
    public Employee(String firstName, String lastName, String employeeNumber, ParkingSpace parkingSpace, Department department) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.employeeNumber = employeeNumber;
	this.parkingSpace = parkingSpace;
	this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }
    
    
}
