package tt.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tt.domain.PersonnelTT;

/**
 * Session Bean implementation class GestionUtilisateur
 */
@Stateless
public class GestionUtilisateur implements GestionUtilisateurLocal {

	
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public GestionUtilisateur() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public PersonnelTT authentifier(String login, String password) {
		PersonnelTT personnelTT = null;
		Query query = entityManager
				.createQuery("select p from PersonnelTT p where p.login=:login and p.password=:password");
		query.setParameter("login", login).setParameter("password", password);
		try {
			personnelTT = (PersonnelTT) query.getSingleResult();
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "authentication failed with login="+login+" and password="+password);
		}
		return personnelTT;
	}

	@Override
	public boolean existeEmail(String login) {
		boolean exists = false;
		String jpql = "select case when (count(p) > 0)  then true else false end from PersonnelTT p where p.login=:login";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("login", login);
		exists = (Boolean) query.getSingleResult();
		return exists;
	}

	@Override
	public void sauvegarderPersonnelTT(PersonnelTT personnelTT) {
		entityManager.merge(personnelTT);
		
	}

}
