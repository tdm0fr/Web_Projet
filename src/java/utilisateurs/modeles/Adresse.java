/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.modeles;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Medhy Salim
 */
@Entity  
public class Adresse implements Serializable {  
 
    private static final long serialVersionUID = 1L;  
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private int id;  
    @NotNull @Size(min=1)  
    private String ville;  
    @Pattern(regexp="[0-9]{5}") // On accepte les codes postaux du type "06410"  
    private String codePostal;
    @OneToMany(mappedBy = "adresse")
    private ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();

    public Adresse() {
    }  

    public Adresse(String ville, String codePostal) {  
        this.ville = ville;  
        this.codePostal = codePostal;  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
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
        int hash = 5;
        hash = 31 * hash + this.id;
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
        final Adresse other = (Adresse) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Adresse{" + "id=" + id + ", ville=" + ville + ", codePostal=" + codePostal + ", listeUtilisateurs=" + listeUtilisateurs + '}';
    }
}
