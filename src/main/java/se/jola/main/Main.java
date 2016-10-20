package se.jola.main;

import java.util.List;

import se.jola.entities.Department;
import se.jola.entities.Employee;
import se.jola.entities.ParkingSpace;
import se.jola.exceptions.RepositoryException;
import se.jola.repo.DepartmentRepo;
import se.jola.repo.EmployeeRepo;

public class Main {

    public static void main(String[] args) {

	EmployeeRepo employeeRepo = new EmployeeRepo();
	DepartmentRepo departmentRepo = new DepartmentRepo();

	Department department = new Department("Joakim's crib");

	try {
	    departmentRepo.saveDepartment(department);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	Employee employee = new Employee("joakim", "landstrom", "1");
	ParkingSpace parkingSpace = new ParkingSpace("parkingspace", 1L);

	try {
	    employeeRepo.saveEmployee(employee.setParkingSpace(parkingSpace).setDepartment(department));
	} catch (RepositoryException e) {
	    e.printStackTrace();
	}

	List<Employee> employeeList = null;

	try {
	department =  departmentRepo.getDepartment(1L);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	System.out.println(department.getName());
    }

}
