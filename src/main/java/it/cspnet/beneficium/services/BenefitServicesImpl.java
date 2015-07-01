package it.cspnet.beneficium.services;

import it.cspnet.beneficium.data.AutomobiliRepository;
import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.data.CellulariRepository;
import it.cspnet.beneficium.data.ContrattoTelefonicoRepository;
import it.cspnet.beneficium.data.ContrattoAutoRepository;
import it.cspnet.beneficium.data.DipendentiRepository;
import it.cspnet.beneficium.data.UtenteRepository;
import it.cspnet.beneficium.model.Automobile;
import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.JsonResult;
import it.cspnet.beneficium.model.ContrattoAuto;
import it.cspnet.beneficium.model.ContrattoTelefonico;

import it.cspnet.beneficium.model.Utente;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BenefitServicesImpl implements BenefitServices {

    @Autowired
    private AutomobiliRepository repositoryAutomobile;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private DipendentiRepository dipendenteRepository;

    @Autowired
    private CellulariRepository cellulariRepository;

    @Autowired
    private ContrattoAutoRepository contrattoAutoRepository;

    @Autowired
    private ContrattoTelefonicoRepository contrattiTelefoniciRepository;

    public Cellulare inserisciCellulare(Cellulare cellulare) throws Exception {
        return cellulariRepository.save(cellulare);
    }

   
    public Utente findUtente(Utente u) throws Exception {
        return utenteRepository.findByUsernameAndPassword(u.getUsername(), u.getPassword());
    }
    
    @Transactional
    public void aggiungiAutomobile(Automobile automobile) {
        repositoryAutomobile.save(automobile);
    }

    @Transactional
    public Dipendente aggiungiDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public List<Automobile> listaAutomobileJSON(String codiceFiscale) {
        return repositoryAutomobile.findByDipendente_codiceFiscale(codiceFiscale);
    }

    
    public Collection<Dipendente> listDipendentiJSON() {

        return dipendenteRepository.findAll();
    }

    public List<Utente> listaUtenti() {
        return utenteRepository.findAll();

    }

    @Transactional
    public Automobile salvaautomobile(Automobile a) {
        return repositoryAutomobile.save(a);
    }

    @Override
    @Transactional
    public ContrattoAuto salvaContratto(ContrattoAuto contratto) {

        return contrattoAutoRepository.save(contratto);
    }

    @Transactional
    public ContrattoTelefonico aggiungiContrattoTelefonico(ContrattoTelefonico contrattoTelefonico) {
        return contrattiTelefoniciRepository.save(contrattoTelefonico);
    }

    @Override
    public Collection<Automobile> listAutomobiliJSON(String codiceFiscale) {

        return repositoryAutomobile.findByDipendente_codiceFiscale(codiceFiscale);
    }

    public Collection<Cellulare> listaCellulareJSON(String codiceFiscale) throws Exception {
        Dipendente d = dipendenteRepository.findOne(codiceFiscale);
        return d.getCellulari();
    }

    @Override
    public Collection<ContrattoTelefonico> listaContrattiCellulare(int id) throws Exception {
        Cellulare c = cellulariRepository.findOne(id);
        return c.getContrattiTelefonici();
    }

    @Override
    public Collection<Automobile> listaAuto(String codiceFiscale) {
        Dipendente d = dipendenteRepository.findOne(codiceFiscale);
        return d.getAuto();
    }

    @Override
    public Collection<ContrattoAuto> listaContrattiAuto2(int id) {
        Automobile auto = repositoryAutomobile.findOne(id);
        return auto.getContrattoAuto();
    }

    @Override
    public Automobile findAuto(Automobile auto) {
        Automobile a = repositoryAutomobile.findOne(auto.getIdAuto());
        a.setModello(auto.getModello());
        a.setTarga(auto.getTarga());
        return repositoryAutomobile.save(a);
    }

    @Override
    @Transactional
    public ContrattoAuto modificaContrattoAuto(ContrattoAuto contratto) {
        contrattoAutoRepository.findOne(contratto.getIdContratto()).setAutomobile(contratto.getAutomobile());
        contrattoAutoRepository.findOne(contratto.getIdContratto()).setCostoNoleggio(contratto.getCostoNoleggio());
        contrattoAutoRepository.findOne(contratto.getIdContratto()).setCostoServizi(contratto.getCostoServizi());
        contrattoAutoRepository.findOne(contratto.getIdContratto()).setDataAttivazione(contratto.getDataAttivazione());
        contrattoAutoRepository.findOne(contratto.getIdContratto()).setDataScadenza(contratto.getDataScadenza());
        contrattoAutoRepository.findOne(contratto.getIdContratto()).setKilometriContratto(contratto.getKilometriContratto());
        contrattoAutoRepository.findOne(contratto.getIdContratto()).setSocietaLeasing(contratto.getSocietaLeasing());
        return contrattoAutoRepository.findOne(contratto.getIdContratto());

    }

    @Override
    @Transactional
    public Cellulare saveCellulare(Cellulare cellulare) {
        return cellulariRepository.save(cellulare);
    }
}
