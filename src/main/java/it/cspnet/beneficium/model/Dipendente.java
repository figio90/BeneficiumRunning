/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author corsojava
 */
@Entity
@Table(name = "DIPENDENTI")
public class Dipendente implements Serializable {

    @Id
//    @NotEmpty
    private String codiceFiscale;
//    @NotEmpty
    private String nome;
//    @NotEmpty
    private String cognome;
//    @NotEmpty
    private String indirizzo;
    private float stipendioMensile;
    
    private String societa;
    
    @JsonIgnore
    @OneToMany(mappedBy = "dipendente", fetch = FetchType.LAZY)
    public Collection<Automobile> auto = new ArrayList<Automobile>();

    @JsonIgnore
    @OneToMany(mappedBy = "dipendente", fetch = FetchType.LAZY)
    public Collection<Cellulare> cellulari = new ArrayList<Cellulare>();

    public String getSocieta() {
        return societa;
    }

    public void setSocieta(String societa) {
        this.societa = societa;
    }
    
    

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public float getStipendioMensile() {
        return stipendioMensile;
    }

    public void setStipendioMensile(float stipendioMensile) {
        this.stipendioMensile = stipendioMensile;
    }

    public Collection<Automobile> getAuto() {
        return auto;
    }

    public void setAuto(Collection<Automobile> auto) {
        this.auto = auto;
    }

    public Collection<Cellulare> getCellulari() {
        return cellulari;
    }

    public void setCellulari(Collection<Cellulare> cellulari) {
        this.cellulari = cellulari;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.codiceFiscale != null ? this.codiceFiscale.hashCode() : 0);
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
        final Dipendente other = (Dipendente) obj;
        if ((this.codiceFiscale == null) ? (other.codiceFiscale != null) : !this.codiceFiscale.equals(other.codiceFiscale)) {
            return false;
        }
        return true;
    }

}
