/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.data;

import it.cspnet.beneficium.model.Automobile;
import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.ContrattoAuto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dave
 */
@Repository
public interface ContrattoAutoRepository extends JpaRepository<ContrattoAuto, Integer>{
    List <ContrattoAuto> findByAutomobile(List <Automobile> auto);
}
