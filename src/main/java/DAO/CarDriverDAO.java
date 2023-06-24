package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.CarDTO;
import DTO.DriverDTO;

public class CarDriverDAO {
	
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
		DriverDTO driver=new DriverDTO();
		driver.setId(1);
		driver.setName("ramesh");
		driver.setContact(756479229);
		
		
		DriverDTO driver1=new DriverDTO();
		driver1.setId(2);
		driver1.setName("suresh");
		driver1.setContact(756478729);
		
		
		
		CarDTO car=new CarDTO();
		car.setId(1);
		car.setModel("mhddg67");
		car.setRegNo("567");
		car.setBrand("TATA");
		car.setDriver(driver);
		manager.persist(car);
	
		driver1.setCar(car);
		manager.persist(driver);
		manager.persist(driver1);
		
		
		transaction.commit();
		CloseConnection();
	}

}
