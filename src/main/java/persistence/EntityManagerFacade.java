package persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerFacade {

	private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("database");
	
	private static ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();
	
	public static EntityManager em(){
		if (threadLocal.get() == null || !threadLocal.get().isOpen()){
			threadLocal.set(FACTORY.createEntityManager());
		}
		return threadLocal.get();
	}
	
}
