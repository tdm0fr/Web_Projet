package utilisateurs.gestionnaires;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Musique;

@Stateless
public class GestionnaireMusiques {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private int firstRow = 0;
    private int rowsPerPage = 10;
    private int totalRows;
    private int totalPages;
    private int currentPage = 1;

    public Collection<Musique> getMusicbyPage(int pageNumber) {
        Query q = em.createQuery("select m from MUSIQUE m Order by m.TITRE");
        this.setTotalRows(q.getResultList().size());
        if (this.totalRows % this.rowsPerPage == 0) {
            this.totalPages = this.totalRows / this.rowsPerPage;
        } else {
            this.totalPages = this.totalRows / this.rowsPerPage + 1;
        }
        q.setMaxResults(this.rowsPerPage);
        q.setFirstResult((pageNumber - 1) * this.rowsPerPage);

        return q.getResultList();
    }

    /**
     * Méthode getAllMusics : Permet de lister les musiques
     *
     * @return
     */
    public Collection<Musique> getAllMusics() {
        Query q = em.createQuery("select m from Musique m");
        return q.getResultList();
    }
    
     public void ajouterMusique(Musique m) {
        em.persist(m);
    }
    
    public Collection<Musique> showMusicsByName(String titre) {
        Query q = em.createQuery("select m from Musique m where m.titre='" + titre + "'");
        return q.getResultList();
    }
    
    public Collection<Musique> showMusicsByArtist(String nomArtiste) {
        Query q = em.createQuery("select id from Artiste a where a.nomArtiste ='"+nomArtiste+"'");
        Object idArtiste = q.getSingleResult();
        Query q1;
        q1 = em.createQuery("select m from Musique m where m.artiste_id='" + idArtiste + "'");
        return q1.getResultList();
    }

    public Musique getMusicByName(String titre) {
        Query q = em.createQuery("select m from Musique m where m.titre ='" + titre + "'").setMaxResults(1);
        Musique m1 = null;
        try {
            m1 = (Musique) q.getSingleResult();
        } catch (NoResultException e) {
            m1 = null;
        }
        return m1;
    }

    // --- Getters
    //
    public int getFirstRow() {
        return firstRow;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    // --- Setters
    //
    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }


}
