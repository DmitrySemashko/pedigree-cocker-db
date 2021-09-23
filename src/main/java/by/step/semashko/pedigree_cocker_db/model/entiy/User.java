package by.step.semashko.pedigree_cocker_db.model.entiy;

import by.step.semashko.pedigree_cocker_db.model.enums.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
public class User extends NamedEntity implements UserDetails{
    @Column(name = "password")
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @Transient
    @NotBlank(message = "Password cannot be empty")
    transient private String repeatPassword;
    @Column(name = "email")
    @NotBlank(message = "email cannot be empty")
    private String email;
    @Column(name = "activate")
    private boolean isActive;
    @Column(name = "code")
    private String activationCode;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return super.name;
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

}
