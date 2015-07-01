/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.model;

import java.util.Date;

/**
 *
 * @author corsojava
 */
public class AutomobileView {
    // info dell'auto che vogliamo visualizzare
    private int idAuto;
    private int idContratto;
    private String codiceFiscale;
    private String modello;
    private String targa;
    private Date dataAttivazione;
    private Date dataScadenza;
    private float costoNoleggio;
    private float costoServizi;
    private long kilometriContratto;
    private String societaLeasing;

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public int getIdContratto() {
        return idContratto;
    }

    public void setIdContratto(int idContratto) {
        this.idContratto = idContratto;
    }

    

    
    
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

//    public Date getDataAttivazione() {
//        return dataAttivazione;
//    }
//
//    public void setDataAttivazione(Date dataAttivazione) {
//        this.dataAttivazione = dataAttivazione;
//    }
//
//    public Date getDataScadenza() {
//        return dataScadenza;
//    }
//
//    public void setDataScadenza(Date dataScadenza) {
//        this.dataScadenza = dataScadenza;
//    }

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
    
    
    
}
