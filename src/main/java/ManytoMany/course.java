package ManytoMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class course {
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int duration;
	private double fees;

	
	//here itself we are mentiononig many to many so need to give in students
	//it is owing site 
	@ManyToMany
	List<students> students;


	public course(String name, int duration, double fees) {
		super();
		this.name = name;
		this.duration = duration;
		this.fees = fees;
	}


	@Override
	public String toString() {
		return "course [id=" + id + ", name=" + name + ", duration=" + duration + ", fees=" + fees + ", students="
				+ students + "]";
	}
    
	
	

	
	
	
	
	
}
