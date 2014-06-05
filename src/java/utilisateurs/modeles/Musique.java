package utilisateurs.modeles;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @OneToMany(mappedBy = "musique")
    private Collection<Instrument> listeInstruments;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Artiste artiste;
    private String genre;
    private int annee;
    private String wikiLink;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private String album;    
    
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

    public Collection<Instrument> getListeInstruments() {
        return listeInstruments;
    }

    public void addInstrument(Instrument i) {  
        listeInstruments.add(i);  
    }
        
    public void removeInstrument(Instrument i) {  
        listeInstruments.remove(i);  
    }
    
    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (long) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musique)) {
            return false;
        }
        Musique other = (Musique) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Musique{" + "id=" + id + ", titre=" + titre + ", nbPistes=" + nbPistes + ", listeInstruments=" + listeInstruments + ", artiste=" + artiste + ", genre=" + genre + ", annee=" + annee + ", wikiLink=" + wikiLink + ", album=" + album + '}';
    }
}