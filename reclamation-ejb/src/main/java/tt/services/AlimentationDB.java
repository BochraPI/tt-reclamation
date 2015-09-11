package tt.services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tt.domain.PersonnelTT;
import tt.domain.Reclamation;
import tt.domain.TypeReclamation;

/**
 * Session Bean implementation class AlimentationDB
 */
@Singleton
@Startup
public class AlimentationDB {
	
	@EJB
	GestionReclamationLocal gestionReclamationLocal;
	
	@EJB
	GestionUtilisateurLocal gestionUtilisateurLocal;
	
	@PersistenceContext
	EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public AlimentationDB() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
	public void addData() {
		
		if (!gestionUtilisateurLocal.existeEmail("zied@tt.com")) {
			PersonnelTT personnelTT=new PersonnelTT("zied@tt.com", "zied");
			gestionUtilisateurLocal.sauvegarderPersonnelTT(personnelTT);

		}
		
		if (!gestionUtilisateurLocal.existeEmail("user2@tt.com")) {
			PersonnelTT personnelTT=new PersonnelTT("user2@tt.com", "user2");
			gestionUtilisateurLocal.sauvegarderPersonnelTT(personnelTT);

		}
		
		if (!gestionReclamationLocal.existeTypeReclalamtion("Administrative")) {
			TypeReclamation typeReclamation=new TypeReclamation(1, "Administrative");
			gestionReclamationLocal.ajouterTypeReclamation(typeReclamation);
		}
		
		if (!gestionReclamationLocal.existeTypeReclalamtion("Matériel défectueux")) {
			TypeReclamation typeReclamation=new TypeReclamation(1, "Matériel défectueux");
			gestionReclamationLocal.ajouterTypeReclamation(typeReclamation);
		}
		
		Reclamation reclamation=new Reclamation("La poste", "D0122", "06-09-2015", "un jour");
		entityManager.persist(reclamation);
		
	}

}
