
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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "CONTRATTO_AUTO")
public class ContrattoAuto implements Serializable {
    
    @Id
    @GeneratedValue
    private int idContratto;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataAttivazione;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataScadenza;
    private float costoNoleggio;
    private float costoServizi;   
    private boolean scaduto;
    private long kilometriContratto;
    private String societaLeasing;
    private String fileContratto;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Automobile automobile;
    
   

    public int getIdContratto() {
        return idContratto;
    }

    public void setIdContratto(int idContratto) {
        this.idContratto = idContratto;
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

    public String getFileContratto() {
        return fileContratto;
    }

    public void setFileContratto(String fileContratto) {
        this.fileContratto = fileContratto;
    }

    public float getCostoNoleggio() {
        return costoNoleggio;
    }

    public void setCostoNoleggio(float costoNoleggio) {
        this.costoNoleggio = costoNoleggio;
    }

    public float getCostoServizi() {
        return costoServizi;
    }

    public void setCostoServizi(float costoServizi) {
        this.costoServizi = costoServizi;
    }

    public boolean isScaduto() {
        return scaduto;
    }

    public void setScaduto(boolean scaduto) {
        this.scaduto = scaduto;
    }

    public long getKilometriContratto() {
        return kilometriContratto;
    }

    public void setKilometriContratto(long kilometriContratto) {
        this.kilometriContratto = kilometriContratto;
    }

    public String getSocietaLeasing() {
        return societaLeasing;
    }

    public void setSocietaLeasing(String societaLeasing) {
        this.societaLeasing = societaLeasing;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }

  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idContratto;
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
        final ContrattoAuto other = (ContrattoAuto) obj;
        if (this.idContratto != other.idContratto) {
            return false;
        }
        return true;
    }
    
    
    
   

}