package com.miportfolio.backenddlpf.Service;

import com.miportfolio.backenddlpf.Entity.Persona;
import com.miportfolio.backenddlpf.Interface.IPersonaService;
import com.miportfolio.backenddlpf.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class implementPersonaService implements IPersonaService {
    @Autowired //conexion a clase repositorio donde está la conexion JPA.
        public IPersonaRepository iPersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        //List<Persona> persona = iPersonaRepository.findAll();
        //return persona;
        return iPersonaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        //Persona persona = iPersonaRepository.findById(id).orElse(null);
        //return persona;
        return iPersonaRepository.findById(id).orElse(null);
    }
    
}
