package OneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PlayerDTO {
	
	@Id
	private String name;
	private String role;
	private int jersy_no;

}
