
package com.miportfolio.backenddlpf.Controller;

import com.miportfolio.backenddlpf.Dto.dtoExperiencia;
import com.miportfolio.backenddlpf.Entity.Experiencia;
import com.miportfolio.backenddlpf.Security.Controller.Mensaje;
import com.miportfolio.backenddlpf.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (sExperiencia.existByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia= new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE());
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada con éxito"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        if(!sExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El "+id+" ingresado, no existe"), HttpStatus.BAD_REQUEST);
        if(sExperiencia.existByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El campo ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
    
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Los datos fueron actualizados"), HttpStatus.OK);
    }
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sExperiencia.existById(id))
           return new ResponseEntity(new Mensaje("El "+id+" no existe"), HttpStatus.BAD_REQUEST);
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Los datos fueron eliminados"), HttpStatus.OK);
    }

}
