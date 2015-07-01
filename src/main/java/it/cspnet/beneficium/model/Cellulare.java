package it.cspnet.beneficium.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CELLULARI")
public class Cellulare implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    private String numero;

    @NotEmpty
    private String numeroSim;

    @NotEmpty
    private String modello;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "cellulare")
    private List<ContrattoTelefonico> contrattiTelefonici;

   
    @ManyToOne
    private Dipendente dipendente = new Dipendente();

    public String getNumeroSim() {
        return numeroSim;
    }

    public void setNumeroSim(String numeroSim) {
        this.numeroSim = numeroSim;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public List<ContrattoTelefonico> getContrattiTelefonici() {
        return contrattiTelefonici;
    }

    public void setContrattiTelefonici(List<ContrattoTelefonico> contrattiTelefonici) {
        this.contrattiTelefonici = contrattiTelefonici;
    }

       public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Cellulare other = (Cellulare) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
