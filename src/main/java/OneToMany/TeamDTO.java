package OneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class TeamDTO {
	
	@Id
	private String name;
	private String Coach;
	private String city;
	@OneToMany
	private List<PlayerDTO> Players;

}
