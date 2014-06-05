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

@Entity
public class Musique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private int nbPistes;
    private String annee;
    private String urlWiki;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<Instrument> instruments;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Artiste artiste;

    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments;
    }

    public Musique() {
    }

    public Musique(final String titre, final int nbPistes, final String annee, final String urlWiki) {
        this.titre = titre;
        this.nbPistes = nbPistes;
        this.annee = annee;
        this.urlWiki = urlWiki;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getUrlWiki() {
        return urlWiki;
    }

    public void setUrlWiki(String urlWiki) {
        this.urlWiki = urlWiki;
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
        return "utilisateurs.modeles.Musique[ id=" + id + titre + " ]";
    }

}
