/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.modeles;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Medhy Salim
 */
@Entity
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;  
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private int id;
    private String nom;
    private String photoURL;
    private String resume;
    private String wikipediaURL;
    @OneToMany(mappedBy = "album")
    private Collection<Musique> listeMusiques;
    @ManyToMany
    private Collection<Artiste> listeArtistes;

    public Album() {
    }

    public Album(String nom, String photoURL, String resume, String wikipediaURL) {
        this.nom = nom;
        this.photoURL = photoURL;
        this.resume = resume;
        this.wikipediaURL = wikipediaURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getWikipediaURL() {
        return wikipediaURL;
    }

    public void setWikipediaURL(String wikipediaURL) {
        this.wikipediaURL = wikipediaURL;
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

    public Collection<Artiste> getListeArtistes() {
        return listeArtistes;
    }
    
    public void addArtiste(Artiste a) {  
        listeArtistes.add(a);  
    }
        
    public void removeArtiste(Artiste a) {  
        listeArtistes.remove(a);  
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final Album other = (Album) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", nom=" + nom + ", photoURL=" + photoURL + ", resume=" + resume + ", wikipediaURL=" + wikipediaURL + ", listeMusiques=" + listeMusiques + '}';
    }
}