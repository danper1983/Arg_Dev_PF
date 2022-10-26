
package com.miportfolio.backenddlpf.Service;

import com.miportfolio.backenddlpf.Entity.Experiencia;
import com.miportfolio.backenddlpf.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list(){
       return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return rExperiencia.findbyNombreE(nombreE);
    }
    
    public void save(Experiencia exp){
        rExperiencia.save(exp);
    }
    
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    public boolean existById(int id){
        return rExperiencia.existsById(id);
    } 
    
    public boolean existByNombreE (String nombreE){
        return rExperiencia.existbyNombreE(nombreE);
    }
    
    
}
