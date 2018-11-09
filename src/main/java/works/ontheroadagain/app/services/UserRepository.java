package works.ontheroadagain.app.services;

import org.springframework.data.repository.CrudRepository;
import works.ontheroadagain.app.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
