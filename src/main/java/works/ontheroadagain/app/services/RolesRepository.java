package works.ontheroadagain.app.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import works.ontheroadagain.app.models.Role;

import java.util.List;

public interface RolesRepository extends CrudRepository<Role, Long> {
    Role findById(Long id);
}
