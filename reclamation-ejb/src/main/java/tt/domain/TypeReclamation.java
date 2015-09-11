package tt.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeReclamation
 *
 */
@Entity

public class TypeReclamation implements Serializable {

	
	private Integer id;
	private String type;
	private static final long serialVersionUID = 1L;
	
	private List<Reclamation> reclamations;

	public TypeReclamation() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@OneToMany(mappedBy="typeReclamation")
	public List<Reclamation> getReclamations() {
		return reclamations;
	}
	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
	public TypeReclamation(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
   
}
