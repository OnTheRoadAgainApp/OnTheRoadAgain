package works.ontheroadagain.app.servieces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.UserWithRoles;
import works.ontheroadagain.app.repositories.UsersRepository;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UsersRepository usersRepository;

    public UserDetailsLoader(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }
}
