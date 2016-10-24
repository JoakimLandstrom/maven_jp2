package se.jola.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "departments")
    private Collection<Employee> employees;

    protected Department() {
    }

    public Department(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public Department setName(String name) {
	this.name = name;

	return this;
    }
    
    public Long getId() {
	return id;
    }
    
    public Collection<Employee> getEmployees() {
	return employees;
    }
}
