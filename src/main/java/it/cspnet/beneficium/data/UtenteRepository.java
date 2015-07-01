/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.data;

import it.cspnet.beneficium.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dave
 */
@Repository
public interface UtenteRepository extends JpaRepository<Utente,String>{
    Utente findByUsernameAndPassword(String username, String password);
    
    
}
