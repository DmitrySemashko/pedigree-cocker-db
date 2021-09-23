package by.step.semashko.pedigree_cocker_db.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
