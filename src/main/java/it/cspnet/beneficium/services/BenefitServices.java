
package it.cspnet.beneficium.services;

import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.Utente;
import it.cspnet.beneficium.model.Automobile;

import it.cspnet.beneficium.model.JsonResult;

import it.cspnet.beneficium.model.ContrattoAuto;
import it.cspnet.beneficium.model.ContrattoTelefonico;

import java.util.Collection;
import java.util.List;


public interface BenefitServices {

    public Cellulare inserisciCellulare(Cellulare cellulare) throws Exception;

    public Utente findUtente(Utente u) throws Exception;

    public Dipendente aggiungiDipendente(Dipendente dipendente);

    public void aggiungiAutomobile(Automobile automobile);

    public Collection<Cellulare> listaCellulareJSON(String codiceFiscale) throws Exception;

    public Collection<Dipendente> listDipendentiJSON();

    public List<Utente> listaUtenti();

    public List<Automobile> listaAutomobileJSON(String codiceFiscale);

    public Automobile salvaautomobile(Automobile a);

    public ContrattoTelefonico aggiungiContrattoTelefonico(ContrattoTelefonico contrattoTelefonico);

    public ContrattoAuto salvaContratto(ContrattoAuto contratto);

    public Collection<Automobile> listAutomobiliJSON(String codiceFiscale);

    public Collection<ContrattoTelefonico> listaContrattiCellulare(int id)throws Exception;

    public Collection<Automobile> listaAuto(String codiceFiscale);

    public Collection<ContrattoAuto> listaContrattiAuto2(int id);

    public Automobile findAuto(Automobile Auto);

    public ContrattoAuto modificaContrattoAuto(ContrattoAuto contratto);

    public Cellulare saveCellulare(Cellulare cellulare);




}
