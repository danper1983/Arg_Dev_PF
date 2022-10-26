
package com.miportfolio.backenddlpf.Repository;

import com.miportfolio.backenddlpf.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findbyNombreE(String nombreE);
    public boolean existbyNombreE (String nombreE);
    
}
