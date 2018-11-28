package works.ontheroadagain.app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import works.ontheroadagain.app.services.RolesRepository;

import java.util.Collection;
import java.util.List;

public class UserWithRoles extends User implements UserDetails {



    private String userRole;

    public UserWithRoles(User user) {
        super(user);  // Call the copy constructor defined in User
        this.userRole = user.getRole().getName();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(userRole);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserRole() {
        return userRole;
    }
}

