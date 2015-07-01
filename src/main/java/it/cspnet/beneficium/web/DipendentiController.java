/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.model.JsonResult;
import it.cspnet.beneficium.model.Utente;
import it.cspnet.beneficium.services.BenefitServices;
import java.util.Collection;
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

/**
 *
 * @author corsojava
 */
@Controller
public class DipendentiController {

    @Autowired
    private BenefitServices servizi;

    
    @RequestMapping(value = "inseriscidipendente", method = RequestMethod.GET)
    @ModelAttribute("dip")
    public Dipendente creaDipendente() throws Exception {
        return new Dipendente();
    }
    
     @ModelAttribute("utente")
    public Utente creaUtente() throws Exception {
        return new Utente();
    }
    
    @RequestMapping(value = "inseriscidipendentejson", method = RequestMethod.POST)
    public @ResponseBody JsonResult nuovoDipendente(HttpServletRequest req,@Valid @RequestBody Dipendente dip, BindingResult result) {
 
            
            Dipendente d = servizi.aggiungiDipendente(dip);
            
            JsonResult j = new JsonResult();
            
            if(d != null){
           
            j.setOggetto(servizi.listDipendentiJSON());
            j.setMessaggio("inserimento corretto");
            j.setStatus(true);
            }
            else{
            j.setMessaggio("inserimento sbagliato");  
            j.setStatus(false);
            }
            
            return j;

    }

    
        @RequestMapping(value = "listadipendentijson", method = RequestMethod.GET)
        public @ResponseBody JsonResult listaDipendentiJSON(){
             Collection<Dipendente> dip =servizi.listDipendentiJSON();
             JsonResult js = new JsonResult();
             js.setOggetto(dip);
             js.setStatus(true);
             js.setMessaggio("ok");
             
             System.out.println("dip size"+dip.size());
             return js;
        }


}