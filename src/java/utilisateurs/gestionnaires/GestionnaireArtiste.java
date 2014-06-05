/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Artiste;

/**
 *
 * @author naana_on
 */
@Stateless
public class GestionnaireArtiste {

    @PersistenceContext
    private EntityManager em;

    public Artiste ajouterArtiste(String nomArtiste) {
        Artiste a = new Artiste(nomArtiste);
        em.persist(a);
        return a;
    }

    public Collection<Artiste> getAllArtists() { 
        Query q = em.createQuery("select a from Artiste a");
        return q.getResultList();
    }

    public Collection<Artiste> showArtistsByName(String nom) {
        Query q = em.createQuery("select a from Artiste a where a.nomArtiste='" + nom + "'");
        return q.getResultList();
    }
    
}
