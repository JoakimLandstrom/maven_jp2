package se.jola.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
    
    @ManyToMany
    private Collection<Department> departments;
    
    @OneToOne
    @JoinColumn(unique = true)
    private ParkingSpace parkingSpace;
    
    protected Employee(){}
    
    public Employee(String firstName, String lastName, String employeeNumber, ParkingSpace parkingSpace, Collection<Department> departments) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.employeeNumber = employeeNumber;
	this.parkingSpace = parkingSpace;
	this.departments = departments;
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

    public Collection<Department> getDepartments() {
        return departments;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }
    
    public Employee addDepartment(Department department){
	departments.add(department);
	return this;
    }
}
