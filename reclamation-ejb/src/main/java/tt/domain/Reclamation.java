package tt.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity

public class Reclamation implements Serializable {

	
	private Integer id;
	private String nom;
	private String numLigne;
	private String date;
	private String duree;
	private static final long serialVersionUID = 1L;
	
	private PersonnelTT personnelTT;
	private TypeReclamation typeReclamation;

	public Reclamation() {
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
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getNumLigne() {
		return this.numLigne;
	}

	public void setNumLigne(String numLigne) {
		this.numLigne = numLigne;
	}   
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}   
	public String getDuree() {
		return this.duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}
	@ManyToOne
	public PersonnelTT getPersonnelTT() {
		return personnelTT;
	}
	public void setPersonnelTT(PersonnelTT personnelTT) {
		this.personnelTT = personnelTT;
	}
	
	@ManyToOne
	public TypeReclamation getTypeReclamation() {
		return typeReclamation;
	}
	public void setTypeReclamation(TypeReclamation typeReclamation) {
		this.typeReclamation = typeReclamation;
	}
	public Reclamation(String nom, String numLigne, String date, String duree) {
		super();
		this.nom = nom;
		this.numLigne = numLigne;
		this.date = date;
		this.duree = duree;
	}
   
}
