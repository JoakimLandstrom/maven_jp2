package se.jola.repo;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import se.jola.entities.Department;
import se.jola.exceptions.RepositoryException;

public class DepartmentRepo {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

    EntityManager manager;

    private EntityManager getManager() {
	return FACTORY.createEntityManager();
    }

    public void saveDepartment(Department department) throws RepositoryException {
	EntityManager manager = FACTORY.createEntityManager();
	try {

	    manager = getManager();

	    manager.getTransaction().begin();

	    manager.persist(department);

	    manager.getTransaction().commit();

	} catch (PersistenceException e) {
	    throw new RepositoryException("");
	} finally {
	    manager.close();
	}

    }

    public Department getDepartment(Long id) throws RepositoryException {
	try {
	    manager = getManager();

	    return manager.find(Department.class, id);

	} catch (PersistenceException e) {
	    e.printStackTrace();
	    throw new RepositoryException("");
	} finally {
	    manager.close();
	}
    }

    public Collection<Department> getDepartmentsByEmployee(Long employeeId) throws RepositoryException {

	try {

	    manager = getManager();

	    return manager
		    .createQuery("SELECT d FROM Department d JOIN FETCH d.employees e WHERE e.id = :id", Department.class)
		    .setParameter("id", employeeId).getResultList();

	} catch (PersistenceException e) {
	    e.printStackTrace();
	    throw new RepositoryException("");
	}finally{
	    manager.close();
	}
    }

}
