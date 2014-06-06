package utilisateurs.gestionnaires;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Musique;

/**
 *
 * @author Medhy Salim
 */
@Stateless
public class GestionnaireMusiques {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private int LigneUne = 0;
    private int nbLignesParPage = 10;
    private int nbLignes;
    private int nbPages;
    private int pageCourante = 1;

    public Collection<Musique> getMusiquesParPage(int pageID) {
        
        Query q = em.createQuery("select m from Musique m Order by m.titre");
        
        this.setNbLignes(q.getResultList().size());
        this.appliquerPagination();

        q.setFirstResult((pageID - 1) * this.nbLignesParPage);
        q.setMaxResults(this.nbLignesParPage);

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

    /**
     * Méthode getAllMusiques : Permet de lister les musiques
     *
     * @return
     */
    public Collection<Musique> getAllMusiques() {
        Query q = em.createQuery("select m from Musique m Order by m.titre");
        return q.getResultList();
    }
    
    public void addMusique(String titre, int nbPistes, String genre, int annee, String wikiLink) {
        Musique m = new Musique(titre, nbPistes, genre, annee, wikiLink);
        em.persist(m);
    }
    
    public Collection<Musique> getMusiqueParID(int id){
        Query q = em.createQuery("select m from Musique m where m.id=:id");
        q.setParameter("id", id);
        return q.getResultList();
    }
    
    public Collection<Musique> getMusiqueParTitre(String titre) {
        Query q = em.createQuery("select m from Musique m where m.titre=:titre");
        return q.getResultList();
    }
    
    public Collection<Musique> getMusiqueParArtiste(String nom) {
        Query q = em.createQuery("select a.id from Artiste a where a.nom=:nom");
        q.setParameter("nom", nom);
        Object idArtiste = q.getSingleResult();
        q = em.createQuery("select m from Musique m where m.artiste.id =:idArtiste");
        q.setParameter("idArtiste", idArtiste);
        return q.getResultList();
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
