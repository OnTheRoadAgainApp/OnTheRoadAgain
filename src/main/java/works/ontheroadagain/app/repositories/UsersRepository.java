package works.ontheroadagain.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import works.ontheroadagain.app.models.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByFirst(String first);
}


