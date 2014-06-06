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
import utilisateurs.modeles.Album;

/**
 *
 * @author Franck Munier & Medhy Salim
 */
@Stateless
public class GestionnaireAlbums {

    @PersistenceContext
    private EntityManager em;
    private int LigneUne = 0;
    private int nbLignesParPage = 10;
    private int nbLignes;
    private int nbPages;
    private int pageCourante = 1;

    public Collection<Album> getAllAlbumsParPage(int pageID) {
        Query q = em.createQuery("select a from Album a Order by a.nom");
        this.setNbLignes(q.getResultList().size());
        this.appliquerPagination();

        q.setFirstResult((pageID - 1) * this.nbLignesParPage);
        q.setMaxResults(this.nbLignesParPage);

        return q.getResultList();
    }

    public Collection<Album> getAlbumsParNom(String nom) {
        Query q = em.createQuery("select a from Album a where a.nom=:nom");
        q.setParameter("nom", nom);
        return q.getResultList();
    }
    
    public Collection<Album> getAlbumsParArtiste(String nom) {
        Query q = em.createQuery("select a.id from Artiste a where a.nom=:nom");
        q.setParameter("nom", nom);
        Object idArtiste = q.getSingleResult();
        q = em.createQuery("select a from Album a, Artiste ar where ar.id=:idArtiste");
        q.setParameter("idArtiste", idArtiste);
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
