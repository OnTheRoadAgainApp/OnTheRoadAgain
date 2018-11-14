package works.ontheroadagain.app.services;

import org.springframework.data.repository.CrudRepository;
import works.ontheroadagain.app.models.Role;
import works.ontheroadagain.app.models.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByFirst(String first);
    User findById(Long id);
    List<User> findAllByRole(Role role);
}
