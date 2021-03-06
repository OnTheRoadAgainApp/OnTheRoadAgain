package works.ontheroadagain.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import works.ontheroadagain.app.services.UserDetailsLoader;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader) // How to find users by their username
                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/default") // user's home page, it can be any URL

                .permitAll() // Anyone can go to the login page

                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // append a query string value

                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeRequests()
                .antMatchers("/") // anyone can see the home and the ads pages
                .permitAll()

                /* Pages that require authentication */
                .and()
                .authorizeRequests()
                .antMatchers("/technicians", "/vehicleAppointment", "/booking/service/{id}") //put for each role 402 - access is denied
                .hasAuthority("TECHNICIAN")
                .and()
                .authorizeRequests()
                .antMatchers("/advisor") //put for each role
                .hasAuthority("ADVISOR")
                .and()
                .authorizeRequests()
                .antMatchers("/profile", "/vehicles/add", "vehicles/book", "/booking/create", "/payments") //put for each role
                .hasAuthority("CUSTOMER")
                .and()
                .authorizeRequests()
                .antMatchers("/book/{id}") 
                .hasAnyAuthority("ADVISOR", "CUSTOMER")
//                .and()
//                .authorizeRequests()
//
//                //I'll add these things below later
//                .antMatchers(
//                        "/profile", // user profile, only authenticated users can go there
//                        "/vehicles/add", // add vehicles,  only authenticated users can go there
//                        "/vehicles/book" // book service, only authenticated users can go there
//
//                )
//                .authenticated()
        ;
    }
}