package ManytoMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class courseCrud {
	public EntityManager getManager() {
		return Persistence.createEntityManagerFactory("hibernateMapping").createEntityManager();
	}
	public void saveCourse(course course) {
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(course);
		transaction.commit();
	}

}
