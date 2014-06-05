/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author naana_on
 */
@Entity
public class Instrument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Musique idmusique;
    private String nomInstrument;

    public Instrument() {
    }
    
    public Instrument(final Musique idmusique, final String nomInstrument){
        this.idmusique = idmusique;
        this.nomInstrument=nomInstrument;
    }
    
    public Instrument(final String nomInstrument){
        this.nomInstrument=nomInstrument;
    }

    public String getNomInstrument() {
        return nomInstrument;
    }

    public void setNomInstrument(String nomInstrument) {
        this.nomInstrument = nomInstrument;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrument)) {
            return false;
        }
        Instrument other = (Instrument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Instrument[ id=" + id + " ]";
    }
    
}
