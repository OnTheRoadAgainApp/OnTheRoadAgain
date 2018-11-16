package works.ontheroadagain.app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import works.ontheroadagain.app.models.*;
import works.ontheroadagain.app.services.*;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@Component
public class DatabaseSeeder {
    private final RolesRepository roleRepo;
    private final ServiceTypeRepository serviceTypeRepo;
    private final VehicleRepository vehicleRepo;
    private final UserRepository userRepo;
    private final EventRepository eventRepo;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public DatabaseSeeder(RolesRepository roleRepo, ServiceTypeRepository serviceTypeRepo, VehicleRepository vehicleRepo, UserRepository userRepo, EventRepository eventRepo, PasswordEncoder passwordEncoder) {
        this.roleRepo = roleRepo;
        this.serviceTypeRepo = serviceTypeRepo;
        this.vehicleRepo = vehicleRepo;
        this.userRepo = userRepo;
        this.eventRepo = eventRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRoles();
        seedServiceTypes();
        seedUsers();
        seedVehicle();
        seedEvents();
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

    private void seedServiceTypes() {
        long count = StreamSupport.stream(
                serviceTypeRepo.findAll().spliterator(),
                false)
                .count();
        if (count < 8
                ) {
            ServiceType types[] = {
                    new ServiceType("Lube, Oil, and Filter"),
                    new ServiceType("Tire Rotation"),
                    new ServiceType("Fuel System Service"),
                    new ServiceType("Engine Air Filter Replacement"),
                    new ServiceType("Scheduled Maintenance by Mileage"),
                    new ServiceType("Battery Replacement"),
                    new ServiceType("Brake Service"),
                    new ServiceType("Diagnostics"),
                    new ServiceType("Wheel Alignment")
            };
            serviceTypeRepo.save(Arrays.asList(types));

        }
    }

    private void seedUsers() {
        long count = StreamSupport.stream(
                userRepo.findAll().spliterator(),
                false)
                .count();
        if (count < 6) {
            User users[] = {
                    new User("Tom", "Cat", "tcat", passwordEncoder.encode("tommyboi"),
                            "tommy@auto.com", 2105543423L,
                            "435 Home Rd", "San Antonio", "TX", 78260L, roleRepo.findOne(3L)),
                    new User("Butch", "Cat", "bcat", passwordEncoder.encode("butchbby"),
                            "butch@auto.com", 2102945476L,
                            "247 Alley Ln", "San Antonio", "TX", 78213L, roleRepo.findOne(3L)),
                    new User("Jerry", "Mouse", "jmouse", passwordEncoder.encode("wheredachz"),
                            "jerry@auto.com", 2104435297L,
                            "432 Home Rd", "San Antonio", "TX", 78260L, roleRepo.findOne(3L)),
                    new User("Willy", "Nelson", "wnelson", passwordEncoder.encode("420blazeit"),
                            "willy@auto.com", 5128537212L,
                            "944 Peace Wy", "Austin", "TX", 78704L, roleRepo.findOne(2L)),
                    new User("Johnny", "Cash", "jcash", passwordEncoder.encode("june4lyfe"),
                            "johnny@auto.com", 4573218305L,
                            "756 Folsom Pr", "Nashville", "TN", 37189, roleRepo.findOne(2L)),
                    new User("Michael", "Strezishar", "mstrezishar", passwordEncoder.encode("#1dude"),
                            "mstrezishar@gmail.com", 2105543423L,
                            "222 Banana Cr", "Converse", "TX", 78109L, roleRepo.findOne(1L))
            };
            userRepo.save(Arrays.asList(users));
        }

    }

    private void seedVehicle() {
        long count = StreamSupport.stream(
                vehicleRepo.findAll().spliterator(),
                false)
                .count();
        if (count < 2) {
            Vehicle mikescars[] = {
                    new Vehicle(2004, "2340XT", "Chevrolet", "Tahoe", 215376L, 5L, "White", userRepo.findByFirst("Michael")),
                    new Vehicle(2011, "92WKXY", "Kia", "Sorrento", 125743L, 2L, "Gray", userRepo.findByFirst("Michael"))
            };
            vehicleRepo.save(Arrays.asList(mikescars));
        }
    }


//    private void seedPastAppts() {
//        long count
//    }


    private void seedEvents() {
        long count = StreamSupport.stream(
                eventRepo.findAll().spliterator(),
                false)
                .count();
        if (count < 10) {
            Event events[] = {
                    new Event("Booking Created"),
                    new Event("Vehicle Checked-in"),
                    new Event("Service Started"),
                    new Event("Service Started - Error Encountered"),
                    new Event("Halfway Point Reached"),
                    new Event("Halfway Point Reached - Error Encountered"),
                    new Event("Inspection Underway"),
                    new Event("Inspection Underway - Error Encountered"),
                    new Event("Final Quality Check"),
                    new Event("Vehicle Ready")
            };
            eventRepo.save(Arrays.asList(events));
        }
    }
}



