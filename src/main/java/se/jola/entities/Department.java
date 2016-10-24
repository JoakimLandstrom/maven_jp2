package se.jola.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
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
