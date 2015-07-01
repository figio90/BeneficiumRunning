package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Automobile;
import it.cspnet.beneficium.model.AutomobileView;
import it.cspnet.beneficium.model.ContrattoAuto;
import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.model.JsonResult;
import it.cspnet.beneficium.services.BenefitServices;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContrattoAutomobileController {

    @Autowired
    private BenefitServices servizi;

    @RequestMapping(value = "salvacontratto", method = RequestMethod.GET)
    @ModelAttribute("contratto")
    public ContrattoAuto creaContrattoAuto() throws Exception {
        return new ContrattoAuto();
    }

    @RequestMapping(value = "salvacontratto", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult salvaContratto(@RequestBody ContrattoAuto contratto) {
        JsonResult j = new JsonResult();
        try {
            ContrattoAuto cT = servizi.salvaContratto(contratto);
            ArrayList<ContrattoAuto> contratti = new ArrayList<ContrattoAuto>();
            contratti.add(cT);
            j.setOggetto(contratti);
            j.setMessaggio("inserimento corretto");
            j.setStatus(true);
            
        } catch (Exception ex) {
            System.out.println("************" + ex);
            j.setMessaggio("Problemi inserimento contratto");
            j.setStatus(false);
        } finally {
            return j;
        }
    }
   

    

    @RequestMapping(value = "modificacontratto", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult modificaContratto(@RequestBody ContrattoAuto contratto) {
        JsonResult risultato = new JsonResult();
        ContrattoAuto contratto2 = servizi.modificaContrattoAuto(contratto);
        if (contratto2 != null) {
            risultato.setOggetto(contratto);
            risultato.setMessaggio("contratto inserito con successo");
            risultato.setStatus(true);
        } else {
            risultato.setMessaggio("errore nell'inserimento contratto");
            risultato.setStatus(false);
        }

        return risultato;
    }

    @RequestMapping(value = "ListaContrattiAuto", method = RequestMethod.GET)
    public @ResponseBody
    Collection<AutomobileView> listaContrattiAuto(HttpServletRequest req) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        Collection<ContrattoAuto> lista = servizi.listaContrattiAuto2(id);
        List<AutomobileView> listaAuto = new ArrayList<AutomobileView>();
        for (ContrattoAuto c : lista) {
            AutomobileView aW = new AutomobileView();
            aW.setDataAttivazione(c.getDataAttivazione());
            aW.setCodiceFiscale(c.getAutomobile().getDipendente().getCodiceFiscale());
            aW.setDataScadenza(c.getDataScadenza());
            aW.setCostoNoleggio(c.getCostoNoleggio());
            aW.setCostoServizi(c.getCostoServizi());
            aW.setKilometriContratto(c.getKilometriContratto());
            aW.setSocietaLeasing(c.getSocietaLeasing());
            aW.setIdAuto(id);
            aW.setIdContratto(c.getIdContratto());
            aW.setTarga(c.getAutomobile().getTarga());
            aW.setModello(c.getAutomobile().getTarga());
            listaAuto.add(aW);
        }
        return listaAuto;
    }
}
