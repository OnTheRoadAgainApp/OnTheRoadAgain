package works.ontheroadagain.app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import works.ontheroadagain.app.models.Role;
import works.ontheroadagain.app.services.RolesRepository;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@Component
public class DatabaseSeeder {
    private final RolesRepository roleRepo;


    @Autowired
    public DatabaseSeeder(RolesRepository roleRepo) {
        this.roleRepo = roleRepo;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRoles();
    }

    private void seedRoles() {
        long count = StreamSupport.stream(
                roleRepo.findAll().spliterator(),
                false)
                .count();
        if (count < 3) {
            Role roles[] = {
               new Role("CUSTOMER"),
               new Role("ADVISOR"),
               new Role("TECHNICIAN")
            };
            roleRepo.save(Arrays.asList(roles));
        }
    }


}
