package se.jola.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import se.jola.entities.Employee;
import se.jola.exceptions.RepositoryException;

public class EmployeeRepo {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

    private EntityManager manager;

    private EntityManager getManager() {
	return FACTORY.createEntityManager();
    }

    public void saveEmployee(Employee employee) throws RepositoryException {

	try {
	    manager = getManager();

	    manager.getTransaction().begin();

	    manager.persist(employee);

	    manager.getTransaction().commit();

	} catch (PersistenceException e) {
	    e.printStackTrace();
	    throw new RepositoryException("");
	} finally {
	    manager.close();
	}
    }

}
