package ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PlayerTeamDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void OpenConnection() {
		factory=Persistence.createEntityManagerFactory("hibernateMapping");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	private static void CloseConnection() {
		if (factory!=null) {
			factory.close();
		}if (manager!=null) {
			manager.close();
		}if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		OpenConnection();
		transaction.begin();
		
		TeamDTO dto=new TeamDTO();
		dto.setCity("pune");
		dto.setCoach("zaheer khan");
		dto.setId(1);
		dto.setName("pune warriors");
		manager.persist(dto);
		
		PlayerDTO dto2=new PlayerDTO();
		dto2.setId(1);
		dto2.setJersey_no(98);
		dto2.setName("rohit sharma");
		dto2.setRole("batsman");
		dto2.setTeam(dto);
		manager.persist(dto2);
		
		PlayerDTO dto3=new PlayerDTO();
		dto3.setId(2);
		dto3.setJersey_no(8);
		dto3.setName("bumrah");
		dto3.setRole("bowler");
		dto3.setTeam(dto);
		manager.persist(dto3);
		
		PlayerDTO dto4=new PlayerDTO();
		dto4.setId(3);
		dto4.setJersey_no(7);
		dto4.setName("hardik");
		dto4.setRole("batsman");
		dto4.setTeam(dto);
		manager.persist(dto4);
		
		transaction.commit();
		CloseConnection();
	}

}
