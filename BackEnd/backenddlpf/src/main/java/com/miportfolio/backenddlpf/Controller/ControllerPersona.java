package com.miportfolio.backenddlpf.Controller;

import com.miportfolio.backenddlpf.Dto.dtoPersona;
import com.miportfolio.backenddlpf.Entity.Persona;
import com.miportfolio.backenddlpf.Security.Controller.Mensaje;
import com.miportfolio.backenddlpf.Service.implementPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "http//localhost:4200")
public class ControllerPersona {

    @Autowired
    implementPersonaService iPersonaService;

    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = iPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!iPersonaService.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe " + id), HttpStatus.BAD_REQUEST);
        }

        Persona persona = iPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        if (!iPersonaService.existById(id)) {
            return new ResponseEntity(new Mensaje("El " + id + " ingresado, no existe"), HttpStatus.BAD_REQUEST);
        }
        if (iPersonaService.existByNombre(dtopersona.getNombre()) && iPersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El campo ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }

        Persona personaObj = iPersonaService.getOne(id).get();
        personaObj.setNombre(dtopersona.getNombre());
        personaObj.setApellido(dtopersona.getApellido());
        personaObj.setImg(dtopersona.getImg());
        personaObj.setDescripcionP(dtopersona.getDescripcionP());

        iPersonaService.save(personaObj);
        return new ResponseEntity(new Mensaje("Los datos fueron actualizados"), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!iPersonaService.existById(id)) {
            return new ResponseEntity<>(new Mensaje("El " + id + " no existe"), HttpStatus.BAD_REQUEST);
        }
        iPersonaService.delete(id);
        return new ResponseEntity(new Mensaje("Los datos fueron eliminados"), HttpStatus.OK);
    }

    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (iPersonaService.existByNombre(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona personaObj = new Persona(dtopersona.getNombre(), dtopersona.getApellido(), dtopersona.getDescripcionP(), dtopersona.getImg());
        iPersonaService.save(personaObj);
        
        return new ResponseEntity(new Mensaje("Persona agregada con éxito"), HttpStatus.OK);
    }*/
}
