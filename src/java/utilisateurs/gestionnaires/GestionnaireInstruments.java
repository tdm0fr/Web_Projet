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
import utilisateurs.modeles.Instrument;

/**
 *
 * @author Medhy Salim
 */
@Stateless
public class GestionnaireInstruments {

    @PersistenceContext
    private EntityManager em;
    private int LigneUne = 0;
    private int nbLignesParPage = 10;
    private int nbLignes;
    private int nbPages;
    private int pageCourante = 1;

//    public Instrument addInstrument(String nom, String difficulte) {
//        Instrument i = new Instrument(nom, difficulte);
//        em.persist(i);
//        return i;
//    }

    public Collection<Instrument> getInstrumentsParMusiqueID(int id) {
        Query q = em.createQuery("select i from Instrument i where i.musique.id=:id");
        q.setParameter("id", id);
        return q.getResultList();
    }
    
     /**
     * appliquerPagination : modifie les attributs en fonction du nombre
 de musiques
     */
    public void appliquerPagination() {
        if (this.nbLignes % nbLignesParPage == 0) {
            this.nbPages = this.nbLignes / this.nbLignesParPage;
        } else {
            this.nbPages = this.nbLignes / this.nbLignesParPage + 1;
        }
    }
    
    // --- Getters
    //
    public int getLigneUne() {
        return LigneUne;
    }

    public int getNbLignesParPage() {
        return nbLignesParPage;
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbPages() {
        return nbPages;
    }

    public int getPageCourante() {
        return pageCourante;
    }

    // --- Setters
    //
    public void setLigneUne(int LigneUne) {
        this.LigneUne = LigneUne;
    }

    public void setNbLignesParPage(int nbLignesParPage) {
        this.nbLignesParPage = nbLignesParPage;
    }

    public void setNbLignes(int nbLignes) {
        this.nbLignes = nbLignes;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public void setPageCourante(int pageCourante) {
        this.pageCourante = pageCourante;
    }
}
