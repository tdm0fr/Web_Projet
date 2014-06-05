/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.modeles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
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
public class Artiste implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String resume;
    private String photoURL;
    @OneToMany(mappedBy = "artiste")
    private Collection<Musique> listeMusiques;

    public Artiste() {
    }

    public Artiste(String nom, String resume, String photoLink) {
        this.nom = nom;
        this.resume = resume;
        this.photoURL = photoLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Collection<Musique> getListeMusiques() {
        return listeMusiques;
    }
    
    public void addMusique(Musique m) {  
        listeMusiques.add(m);  
    }
        
    public void removeMusique(Musique m) {  
        listeMusiques.remove(m);  
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Artiste other = (Artiste) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Artiste{" + "id=" + id + ", nom=" + nom + ", resume=" + resume + ", photoURL=" + photoURL + '}';
    }
}