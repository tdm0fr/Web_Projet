/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.modeles;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Medhy Salim
 */
@Entity
public class Abonnement implements Serializable {
    private static final long serialVersionUID = 1L;  
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private int id;
    private int duree;
    private int prix;
    @OneToMany(mappedBy = "abonnement")
    private ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();

    public Abonnement() {
    }

    public Abonnement(int duree, int prix) {
        this.duree = duree;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public ArrayList<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public void addUtilisateur(Utilisateur u) {  
        listeUtilisateurs.add(u);  
    }
        
    public void removeUtilisateur(Utilisateur u) {  
        listeUtilisateurs.remove(u);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Abonnement other = (Abonnement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Abonnement{" + "id=" + id + ", duree=" + duree + ", prix=" + prix + ", listeUtilisateurs=" + listeUtilisateurs + '}';
    }
}