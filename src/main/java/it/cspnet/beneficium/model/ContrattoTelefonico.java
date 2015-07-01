package it.cspnet.beneficium.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "CONTRATTI")
public class ContrattoTelefonico implements Serializable {

    @Id
    @GeneratedValue
    private int idContrattoTelefonico;

    @NotNull
    private float costoBimestrale;

    @NotEmpty
    private String profiloContratto;

    @NotEmpty
    private String tipoContratto;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataAttivazione;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataScadenza;
    
    private boolean scaduto;


    @ManyToOne(cascade = CascadeType.ALL)
    private Cellulare cellulare ;

    public String getTipoContratto() {
        return tipoContratto;
    }

    public void setTipoContratto(String tipoContratto) {
        this.tipoContratto = tipoContratto;
    }

    public int getIdContrattoTelefonico() {
        return idContrattoTelefonico;
    }

    public void setIdContrattoTelefonico(int idContrattoTelefonico) {
        this.idContrattoTelefonico = idContrattoTelefonico;
    }

    public float getCostoBimestrale() {
        return costoBimestrale;
    }

    public void setCostoBimestrale(float costoBimestrale) {
        this.costoBimestrale = costoBimestrale;
    }

    public String getProfiloContratto() {
        return profiloContratto;
    }

    public void setProfiloContratto(String profiloContratto) {
        this.profiloContratto = profiloContratto;
    }

    public boolean isScaduto() {
        return scaduto;
    }

    public void setScaduto(boolean scaduto) {
        this.scaduto = scaduto;
    }

    public Cellulare getCellulare() {
        return cellulare;
    }

    public void setCellulare(Cellulare cellulare) {
        this.cellulare = cellulare;
    }

    public Date getDataAttivazione() {
        return dataAttivazione;
    }

    public void setDataAttivazione(Date dataAttivazione) {
        this.dataAttivazione = dataAttivazione;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }
    
// equals e hashcode sull'id
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idContrattoTelefonico;
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
        final ContrattoTelefonico other = (ContrattoTelefonico) obj;
        if (this.idContrattoTelefonico != other.idContrattoTelefonico) {
            return false;
        }
        return true;
    }

}
