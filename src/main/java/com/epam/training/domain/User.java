package com.epam.training.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Collection;

@MappedSuperclass
@Setter
@Getter
public abstract class User extends DomainEntity implements UserDetails {

    @Column(unique = true)
    protected String username;

    @Column(unique = true)
    protected String email;

    protected String password;

    protected boolean expired;

    protected boolean credentialsExpired;

    protected boolean enabled;

    protected boolean locked;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
