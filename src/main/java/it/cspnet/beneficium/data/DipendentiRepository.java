

package it.cspnet.beneficium.data;
import it.cspnet.beneficium.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DipendentiRepository extends JpaRepository<Dipendente, String>{
    
}
