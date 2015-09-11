package tt.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PersonnelTT
 *
 */
@Entity

public class PersonnelTT implements Serializable {

	
	private Integer id;
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;
	
	private List<Reclamation> reclamations;

	public PersonnelTT() {
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
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(mappedBy="personnelTT")
	public List<Reclamation> getReclamations() {
		return reclamations;
	}
	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
	public PersonnelTT(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
   
}
