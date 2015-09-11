package tt.services;

import javax.ejb.Local;

import tt.domain.PersonnelTT;

@Local
public interface GestionUtilisateurLocal {

	
	public PersonnelTT authentifier(String login, String password);

	boolean existeEmail(String login);

	void sauvegarderPersonnelTT(PersonnelTT personnelTT);
}
