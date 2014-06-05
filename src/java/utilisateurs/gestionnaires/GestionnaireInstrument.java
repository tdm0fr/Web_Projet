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
import utilisateurs.modeles.Musique;
import utilisateurs.modeles.Instrument;

/**
 *
 * @author naana_on
 */
@Stateless
public class GestionnaireInstrument {

    @PersistenceContext  
    private EntityManager em;  
  
    
    public Instrument ajouterInstrument(Musique musique, String nomInstrument) {
        Instrument i = new Instrument(musique, nomInstrument);  
        em.persist(i);  
        return i; 
    }  
    
    public Collection<Instrument> getInstruments(Integer start) {
      Query q = em.createQuery("select i from Instrument i").setFirstResult(start).setMaxResults(10);  
      return q.getResultList();
    }
    
    public Collection<Instrument> getCount() {
            Query q = em.createQuery("select count(i) from Piste p");  
            return q.getResultList();
    }
  
    public Collection<Instrument> getAllInstruments() {  
        Query q = em.createQuery("select i from Instrument i");  
        return q.getResultList();  
    }  
    
     public Collection<Instrument> getInstrumentsByNom(String nomInstrument) {   
        Query q = em.createQuery("select i from Instrument i where i.nomInstrument =:nomInstrument");  
        q.setParameter("nomInstrument", nomInstrument);
        return q.getResultList();  
    }  
    
     public Collection<Instrument> getInstrumentParMusique(int idmusique) {
        Query q = em.createQuery("select i from Instrument i where i.idmusique =:idmusique");
        q.setParameter("idmusique", new Integer(idmusique));
        return q.getResultList();  
    }
    
    public Instrument chercherParNom(String nomInstrument){
        Query q = em.createQuery("select i from Instrument i where i.nomInstrument =:nomInstrument");
        q.setParameter("nomInstrument", nomInstrument);
        List<Instrument> pistes = q.getResultList();
        if(pistes.isEmpty() == true){
            return null;
        }
        else {
            Instrument piste = pistes.get(0);
            return piste;
        }
    }
}
