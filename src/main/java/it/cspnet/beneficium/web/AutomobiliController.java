package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Automobile;
import it.cspnet.beneficium.model.AutomobileView;

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
public class AutomobiliController {

    @Autowired
    private BenefitServices servizi;

    
    @RequestMapping(value = "inserisciauto", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult salvaAuto(HttpServletRequest req, @Valid @RequestBody Automobile automobile, BindingResult result) {
      Automobile a = servizi.salvaautomobile(automobile);
        JsonResult j = new JsonResult();

        if (a != null) {

            j.setOggetto(a);
            j.setMessaggio("inserimento corretto");
            j.setStatus(true);
        } else {
            j.setMessaggio("inserimento sbagliato");
            j.setStatus(false);
        }

        return j;

    }

    @RequestMapping(value = "listaauto", method = RequestMethod.GET)
    public @ResponseBody
    Collection<AutomobileView> ListaAuto(HttpServletRequest req) throws Exception {
        String codiceFiscale = req.getParameter("codiceFiscale");
        Collection<Automobile> lista = servizi.listaAuto(codiceFiscale);
        List<AutomobileView> listaAuto = new ArrayList<AutomobileView>();
        for (Automobile c : lista) {
            AutomobileView aW = new AutomobileView();
            aW.setIdAuto(c.getIdAuto());
            aW.setModello(c.getModello());
            aW.setTarga(c.getTarga());
            aW.setCodiceFiscale(codiceFiscale);
            listaAuto.add(aW);
        }
        return listaAuto;

    }
}
