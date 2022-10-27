package com.miportfolio.backenddlpf.Service;

import com.miportfolio.backenddlpf.Entity.Persona;
import com.miportfolio.backenddlpf.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class implementPersonaService {

    @Autowired //conexion a clase repositorio donde está la conexion JPA.
    public IPersonaRepository iPersonaRepository;

    public List<Persona> list(){
       return iPersonaRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return iPersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return iPersonaRepository.findByNombre(nombre);
    }
    
    public void save(Persona persona){
        iPersonaRepository.save(persona);
    }
    
    public void delete(int id){
        iPersonaRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return iPersonaRepository.existsById(id);
    } 
    
    public boolean existByNombre (String nombre){
        return iPersonaRepository.existByNombre(nombre);
    }
    

}
