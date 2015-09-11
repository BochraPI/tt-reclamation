package tt.services;

import java.util.List;

import javax.ejb.Local;

import tt.domain.Reclamation;
import tt.domain.TypeReclamation;

@Local
public interface GestionReclamationLocal {

	 void ajouterReclamation(Reclamation reclamation);
	 void ajouterTypeReclamation(TypeReclamation typeReclamation);
	 List<Reclamation> listerReclamations();
	 List<TypeReclamation> listerTypeReclamations();
	 boolean existeTypeReclalamtion(String type);
	 TypeReclamation chercherTypeReclamationParType(String type);
	 Boolean updateReclamation(Reclamation reclamation);
	 Boolean deleteReclamation(Reclamation reclamation);
	 
}
