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
import utilisateurs.modeles.Artiste;

/**
 *
 * @author Medhy Salim
 */
@Stateless
public class GestionnaireArtistes {

    @PersistenceContext
    private EntityManager em;
    private int LigneUne = 0;
    private int nbLignesParPage = 10;
    private int nbLignes;
    private int nbPages;
    private int pageCourante = 1;

    public Collection<Artiste> getAllArtistesParPage(int pageID) {
        Query q = em.createQuery("select a from Artiste a Order by a.nom");
        this.setNbLignes(q.getResultList().size());
        this.appliquerPagination();

        q.setFirstResult((pageID - 1) * this.nbLignesParPage);
        q.setMaxResults(this.nbLignesParPage);

        return q.getResultList();
    }
    
    public void addArtiste(String nom, String resume, String photoLink){
        Artiste a = new Artiste(nom, resume, photoLink);
        em.persist(a);
    }
    
    public Collection<Artiste> getAllArtistes() {
        Query q = em.createQuery("select a from Artiste a Order by a.nom");
        return q.getResultList();
    }

    public Collection<Artiste> getArtisteParNom(String nom) {
        Query q = em.createQuery("select a from Artiste a where a.nom=:nom");
        q.setParameter("nom", nom);
        return q.getResultList();
    }

    /**
     * applyRowsPagesUpdates : modifie les attributs en fonction du nombre
     * d'utilisateurs
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
