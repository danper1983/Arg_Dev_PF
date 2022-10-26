package com.miportfolio.backenddlpf.Controller;

import com.miportfolio.backenddlpf.Entity.Persona;
import com.miportfolio.backenddlpf.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http//localhost:4200")
public class ControllerPersona {
    @Autowired //conexion al servicio
        private IPersonaService ipersonaservice;
    
    @GetMapping ("/personas/get")
    public List<Persona> getPersona(){
        return ipersonaservice.getPersona();
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @PostMapping ("/personas/create")
    public String createPersona(@RequestBody Persona persona){
        ipersonaservice.savePersona(persona);
        return "La Persona fue creada correctamente.";
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @DeleteMapping ("/personas/delete/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaservice.deletePersona(id);
        return "La persona, fue eliminada correctamente.";
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @PutMapping("/personas/edit/{id}")
        public String updatePersona(@PathVariable Long id,
                                    @RequestParam("nombre") String nuevoNombre,
                                    @RequestParam("apellido") String nuevoApellido,
                                    @RequestParam("img") String nuevaImg) {
            Persona persona = ipersonaservice.findPersona(id);
            
            persona.setNombre(nuevoNombre);
            persona.setApellido(nuevoApellido);
            persona.setImg(nuevaImg);
            
            ipersonaservice.savePersona(persona);
        return nuevoNombre + " " + nuevoApellido + " fue actualizada con éxito";
        }
    @GetMapping("/personas/get_perfil")
    public Persona findPersona(){
        return ipersonaservice.findPersona((long)1);
    }
}
