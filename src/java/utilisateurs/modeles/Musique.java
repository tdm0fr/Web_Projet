package utilisateurs.modeles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Medhy Salim
 */

@Entity
public class Musique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private int nbPistes;
//    @OneToMany(mappedBy = "musique")
//    private Collection<Instrument> listeInstruments;
//    @ManyToMany
//    private Collection<Artiste> listeArtistes;
    private String genre;
    private int annee;
    private String wikiLink;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private Album album;    
    
    public Musique() {
    }

    public Musique(String titre, int nbPistes, String genre, int annee, String wikiLink) {
        this.titre = titre;
        this.nbPistes = nbPistes;
        this.genre = genre;
        this.annee = annee;
        this.wikiLink = wikiLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbPistes() {
        return nbPistes;
    }

    public void setNbPistes(int nbPistes) {
        this.nbPistes = nbPistes;
    }

//    public Collection<Instrument> getListeInstruments() {
//        return listeInstruments;
//    }
//
//    public void addInstrument(Instrument i) {  
//        listeInstruments.add(i);  
//    }
//        
//    public void removeInstrument(Instrument i) {  
//        listeInstruments.remove(i);  
//    }
//
//    public Collection<Artiste> getListeArtistes() {
//        return listeArtistes;
//    }
//    
//    public void addArtiste(Artiste a) {  
//        listeArtistes.add(a);  
//    }
//        
//    public void removeArtiste(Artiste a) {  
//        listeArtistes.remove(a);  
//    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

//    public Album getAlbum() {
//        return album;
//    }
//
//    public void setAlbum(Album album) {
//        this.album = album;
//    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Musique other = (Musique) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Musique{" + "id=" + id + ", titre=" + titre + ", nbPistes=" + nbPistes + ",  genre=" + genre + ", annee=" + annee + ", wikiLink=" + wikiLink +'}';// ", album=" + album + '}'; listeInstruments=" + listeInstruments + ", listeArtistes=" + listeArtistes + ",
    }
}