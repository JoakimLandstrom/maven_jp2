package se.jola.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import se.jola.entities.ParkingSpace;
import se.jola.exceptions.RepositoryException;

public class ParkingSpaceRepo {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

    private EntityManager manager;

    private EntityManager getManager() {
	return FACTORY.createEntityManager();
    }
    
    public void saveParkingSpace(ParkingSpace parkingSpace) throws RepositoryException {
   	EntityManager manager = FACTORY.createEntityManager();
   	try{
   	    
   	    manager = getManager();
   	    
   	    manager.getTransaction().begin();
   	    
   	    manager.persist(parkingSpace);
   	    
   	    manager.getTransaction().commit();
   	    
   	}catch (PersistenceException e) {
   	    throw new RepositoryException("");
   	}finally {
   	    manager.close();
   	}
   	
       }

}
