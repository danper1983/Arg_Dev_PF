
package com.miportfolio.backenddlpf.Security.Repository;

import com.miportfolio.backenddlpf.Security.Entity.Rol;
import com.miportfolio.backenddlpf.Security.Enums.RolNombre;
import java.util.Optional;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
