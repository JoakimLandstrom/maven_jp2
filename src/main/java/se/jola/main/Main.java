package se.jola.main;

import se.jola.entities.Department;
import se.jola.entities.Employee;
import se.jola.entities.ParkingSpace;
import se.jola.exceptions.RepositoryException;
import se.jola.repo.DepartmentRepo;
import se.jola.repo.EmployeeRepo;
import se.jola.repo.ParkingSpaceRepo;

public class Main {

    public static void main(String[] args) {

	EmployeeRepo employeeRepo = new EmployeeRepo();
	DepartmentRepo departmentRepo = new DepartmentRepo();
	ParkingSpaceRepo parkingSpaceRepo = new ParkingSpaceRepo();

	Department department = new Department("Joakim's crib");
	ParkingSpace parkingSpace = new ParkingSpace("parkingspace", 1L);
	Employee employee = new Employee("joakim", "landstrom", "1", parkingSpace, department);

	try {
	    parkingSpaceRepo.saveParkingSpace(parkingSpace);
	    departmentRepo.saveDepartment(department);
	    employeeRepo.saveEmployee(employee);
	} catch (RepositoryException e) {
	    e.printStackTrace();
	}

	try {
	    department = departmentRepo.getDepartment(department.getId());

	} catch (RepositoryException e) {

	}

	department.getEmployees().forEach(e -> System.out.println(e.getFirstName()));
    }

}
