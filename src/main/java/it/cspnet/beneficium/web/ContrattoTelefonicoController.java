package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.CellulariView;
import it.cspnet.beneficium.model.ContrattoTelefonico;
import it.cspnet.beneficium.model.JsonResult;
import it.cspnet.beneficium.services.BenefitServices;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContrattoTelefonicoController {

    @Autowired
    private BenefitServices servizi;

  

  

    @RequestMapping(value = "inseriscicontrattojson", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult nuovoContrattoTelefonico(HttpServletRequest req, @RequestBody ContrattoTelefonico contrattoTelefonico, BindingResult result) {
        JsonResult j = new JsonResult();
        try {
            ContrattoTelefonico cT = servizi.aggiungiContrattoTelefonico(contrattoTelefonico);
            ArrayList<ContrattoTelefonico> contratti = new ArrayList<ContrattoTelefonico>();
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

    @RequestMapping(value = "ListaContrattiCellulare", method = RequestMethod.GET)

    public @ResponseBody
    JsonResult listaContrattiCellulari(HttpServletRequest req) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        JsonResult js = new JsonResult();
        try {
            
            js.setOggetto(servizi.listaContrattiCellulare(id));
            js.setStatus(true);
            js.setMessaggio("lista cellulari");
        } catch (Exception ex) {
            js.setStatus(false);
            js.setMessaggio("problemi di accesso a db");
        } finally {
            return js;
        }
   
        
    }
}
