/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Abonnement;

/**
 *
 * @author Medhy Salim
 */
@Stateless
public class GestionnaireAbonnements {

    @PersistenceContext
    private EntityManager em;

    public Collection<Abonnement> getAllAbonnements() {
        Query q = em.createQuery("select a from Abonnement a Order by a.prix");
        return q.getResultList();
    }
    
    public Collection<Abonnement> getAbonnementByID(int ID) {
        Query q = em.createQuery("select a from Abonnement a where a.id=:id");
        q.setParameter("id", ID);
        return q.getResultList();
    }
}