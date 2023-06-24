package ManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class PlayerDTO {
	@Id
	private int id;
	private String Name;
	private int jersey_no;
	private String role;
	@ManyToOne
	private TeamDTO team;
	
	
	
	

}
