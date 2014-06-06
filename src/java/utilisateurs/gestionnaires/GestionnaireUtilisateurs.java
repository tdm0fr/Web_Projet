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
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Franck Munier & Medhy Salim
 */

@Stateless
public class GestionnaireUtilisateurs {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private int rowOne = 0;
    private int nbRowsByPage = 10;
    private int nbRows;
    private int nbPages;
    private int currentPage = 1;

    public Collection<Utilisateur> getUsersByPage(int pageID) {

        Query q = em.createQuery("select u from Utilisateur u Order by u.login");
           
        int nb = q.getResultList().size();
        if (nb == 0) this.setNbRows(0);
        else this.setNbRows(nb);
        this.applyRowsPagesUpdates();

        q.setFirstResult((pageID - 1) * this.nbRowsByPage);
        q.setMaxResults(this.nbRowsByPage);

        return q.getResultList();
    }

    /**
     * Méthode getAllUsers : Permet de lister les utilisateurs
     *
     * @return
     */
    public Collection<Utilisateur> getAllUsers() {
        Query q = em.createQuery("select u from Utilisateur u Order by u.login");
        this.setNbRows(q.getResultList().size());
        this.applyRowsPagesUpdates();
        return q.getResultList();
    }

    /**
     * applyRowsPagesUpdates : modifie les attributs en fonction du nombre
     * d'utilisateurs
     */
    public void applyRowsPagesUpdates() {
        if (this.nbRows % nbRowsByPage == 0) {
            this.nbPages = this.nbRows / this.nbRowsByPage;
        } else {
            this.nbPages = this.nbRows / this.nbRowsByPage + 1;
        }
    }

    /**
     * creerUtilisateursDeTest : génère un nombre donné d'utilisateurs
     */
    public void creerUtilisateursDeTest() {
        createUser("Medhy", "Salim", "admin", "admin");
    }

    public Utilisateur createUser(String lastname, String firstname, String login, String password) {
        Utilisateur u = new Utilisateur(lastname, firstname, login, password);
        em.persist(u);
        return u;
    }

    public void addAbonnementToUser(int userID, int abonnementID) {
        Utilisateur u = em.find(Utilisateur.class, userID);
        Query q = em.createQuery("update Utilisateur u set u.abonnement=:abonnementID where u.id=:userID");
        q.setParameter("abonnementID", abonnementID);
        q.setParameter("userID", userID);
        q.executeUpdate();
    }
    
    public Collection<Utilisateur> getUserByLogin(String login) {
        // Exécution d'une requête équivalente à un select *
        Query q = em.createQuery("select u from Utilisateur u where u.login=:login");
        q.setParameter("login", login);
        return q.getResultList();
    }

    public void updateUser(String prenom, String nom, String login, String password) {
        Query q = em.createQuery("update Utilisateur u set u.firstname=:nom, u.lastname=:prenom, u.password=:password where u.login=:login");
        q.setParameter("login", login);
        q.setParameter("nom", nom);
        q.setParameter("prenom", prenom);
        q.setParameter("password",password);
        q.executeUpdate();
    }
    

    public void deleteUser(String login) {
        // Exécution d'une requête équivalente à un select *
        Query q = em.createQuery("delete from Utilisateur u where u.login=:login");
        q.setParameter("login", login);
        q.executeUpdate();
    }

    public void deleteAllUsers(Collection<Utilisateur> liste) {
        // Exécution d'une requête équivalente à un select *
        String login = null;
        for (Utilisateur u : liste) {
            login = u.getLogin();
            Query q = em.createQuery("delete from Utilisateur u where u.login=:login");
            q.setParameter("login", login);
            q.executeUpdate();
        }
    }

    // --- Getters
    //
    public int getRowOne() {
        return rowOne;
    }

    public int getNbRowsByPage() {
        return nbRowsByPage;
    }

    public int getNbRows() {
        return nbRows;
    }

    public int getNbPages() {
        return nbPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    // --- Setters
    //
    public void setRowOne(int rowOne) {
        this.rowOne = rowOne;
    }

    public void setNbRowsByPage(int nbRowsByPage) {
        this.nbRowsByPage = nbRowsByPage;
    }

    public void setNbRows(int nbRows) {
        this.nbRows = nbRows;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}