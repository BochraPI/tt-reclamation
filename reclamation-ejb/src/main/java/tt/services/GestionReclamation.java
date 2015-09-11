package tt.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tt.domain.Reclamation;
import tt.domain.TypeReclamation;

/**
 * Session Bean implementation class GestionReclamation
 */
@Stateless
public class GestionReclamation implements GestionReclamationLocal {
	
	@PersistenceContext
	EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public GestionReclamation() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterReclamation(Reclamation reclamation) {
		entityManager.persist(reclamation);
		
	}

	@Override
	public void ajouterTypeReclamation(TypeReclamation typeReclamation) {
		entityManager.merge(typeReclamation);
		
	}

	@Override
	public List<Reclamation> listerReclamations() {
		Query query = entityManager.createQuery("select r from Reclalamtion r");
		return query.getResultList();
	}

	@Override
	public List<TypeReclamation> listerTypeReclamations() {
		Query query = entityManager
				.createQuery("select r from TypeReclamation r");
		return query.getResultList();
	}

	@Override
	public boolean existeTypeReclalamtion(String type) {
		boolean exists = false;
		String jpql = "select case when (count(p) > 0)  then true else false end from TypeReclamation p where p.type=:type";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("type", type);
		exists = (Boolean) query.getSingleResult();
		return exists;
	}

	@Override
	public TypeReclamation chercherTypeReclamationParType(String type) {
		TypeReclamation found = null;
		Query query = entityManager
				.createQuery("select t from TypeReclamation t where t.type=:type");
		query.setParameter("type", type);
		try {
			found = (TypeReclamation) query.getSingleResult();
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,"no type found");
		}

		return found;
	}

	@Override
	public Boolean updateReclamation(Reclamation reclamation) {
		entityManager.merge(reclamation);
		return true;
	}

	@Override
	public Boolean deleteReclamation(Reclamation reclamation) {
		entityManager.remove(entityManager.merge(reclamation));
		return true;
	}

}
