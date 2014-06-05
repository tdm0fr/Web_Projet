package utilisateurs.gestionnaires;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Adresse;
import utilisateurs.modeles.Musique;
import utilisateurs.modeles.Utilisateur;

@Stateless
public class GestionnaireUtilisateurs {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private int firstRow = 0;
    private int rowsPerPage = 10;
    private int totalRows;
    private int totalPages;
    private int currentPage = 1;

    public Collection<Utilisateur> getUsersbyPage(int pageNumber) {
        Query q = em.createQuery("select u from Utilisateur u Order by u.login");
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
     * Méthode getAllUsers : Permet de lister les utilisateurs
     *
     * @return
     */
    public Collection<Utilisateur> getAllUsers() {
        Query q = em.createQuery("select u from Utilisateur u Order by u.login");
        this.setTotalRows(q.getResultList().size());
        if (this.totalRows % rowsPerPage == 0) {
            this.totalPages = this.totalRows / this.rowsPerPage;
        } else {
            this.totalPages = this.totalRows / this.rowsPerPage + 1;
        }
        return q.getResultList();
    }

    /**
     * creerUtilisateursDeTest : génère un nombre donné d'utilisateurs
     */
    public void creerUtilisateursDeTest() {

        Adresse biot = new Adresse("Biot", "06410");
        em.persist(biot);
        Adresse valbonne = new Adresse("Valbonne", "06560");
        em.persist(valbonne);
        Adresse nice = new Adresse("Nice", "06000");
        em.persist(nice);

        Utilisateur john = inscription("John", "Lennon", "jlennon", "", biot);
        Utilisateur paul = inscription("Paul", "Mac Cartney", "pmc", "", biot);

        Utilisateur ringo = inscription("Ringo", "Starr", "rstarr", "", nice);
        Utilisateur georges = inscription("Georges", "Harisson", "georgesH", "", valbonne);

        //generateUsersWithQuantity(30);
    }

    public String randomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random randomStr = new Random();
        int randomNum = 3 + (int) (Math.random() * 20);
        for (int i = 0; i < randomNum; i++) {
            char c = chars[randomStr.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

//    public void generateUsersWithQuantity(int quantity)
//    {
//        for(int i = 0; i < quantity; i++)
//        {
//            inscription(this.randomString(),this.randomString(),""+i, "", biot);
//        }
//    }
    public Utilisateur inscription(String nom, String prenom, String login, String password, Adresse a) {
        Utilisateur u = new Utilisateur(nom, prenom, login, password);
        // On met à jour la relation, elle est déjà en base  
        u.setAdresse(a);
        a.addUtilisateur(u);
        em.persist(u);

        return u;
    }
    public void ajouterMusique(Musique m) {
        em.persist(m);
    }
    public void deleteUtilisateur(String login) {
        Query q = em.createQuery("delete from Utilisateur u where u.login='" + login + "'");
        q.executeUpdate();
    }

    public Collection<Utilisateur> showUsersByLogin(String login) {
        Query q = em.createQuery("select u from Utilisateur u where u.login='" + login + "'");
        return q.getResultList();
    }

    
    public void modifieUtilisateur(String firstname, String lastname, String login, Adresse adresse, Timestamp abonnement) {
        Query q = em.createQuery("select u from Utilisateur u where u.login = :login");
        q.setParameter("login", login);
        List<Utilisateur> users = q.getResultList();
        Utilisateur u = users.get(0); 
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setAdresse(adresse);
        u.setAbonnement(abonnement);
             
        em.merge(u);
    }
    

    public Utilisateur getUserByLogin(String login) {
        Query q = em.createQuery("select u from Utilisateur u where u.login ='" + login + "'").setMaxResults(1);
        Utilisateur u1 = null;
        try {
            u1 = (Utilisateur) q.getSingleResult();
        } catch (NoResultException e) {
            u1 = null;
        }
        return u1;
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

    public Collection<Utilisateur> getUsersParVille(int idVille) {
        Adresse a = em.find(Adresse.class, idVille);

        // a est connecté, le get va déclencher un select  
        return a.getUtilisateurs();
    }

}
