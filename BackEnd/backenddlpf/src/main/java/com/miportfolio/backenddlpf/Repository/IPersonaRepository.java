package com.miportfolio.backenddlpf.Repository;

import com.miportfolio.backenddlpf.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
    
}
