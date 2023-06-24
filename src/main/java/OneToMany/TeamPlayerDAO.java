package OneToMany;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TeamPlayerDAO {
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
		
		PlayerDTO player1=new PlayerDTO();
		player1.setName("Bumrah");
		player1.setRole("bowler");
		player1.setJersy_no(7);
		manager.persist(player1);
		
		PlayerDTO player2=new PlayerDTO();
		player2.setName("Rohit");
		player2.setRole("batsman");
		player2.setJersy_no(89);
		manager.persist(player2);
	
		//creating list for returning which has been stored inside the Teamdto as list
		List<PlayerDTO> players=Arrays.asList(player1,player2);
	
		TeamDTO team=new TeamDTO();
		team.setName("Mumbai Indians");
		team.setCity("mumbai");
		team.setCoach("Pollard");
		team.setPlayers(players);
		manager.persist(team);
		
		
		
		
		transaction.commit();
		CloseConnection();
	}

}
