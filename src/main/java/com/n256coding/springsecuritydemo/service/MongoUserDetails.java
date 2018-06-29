package com.n256coding.springsecuritydemo.service;

import com.n256coding.springsecuritydemo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MongoUserDetails implements UserDetails {

    private User user;
    private String username;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;

    public MongoUserDetails(User user) {
        this.user = user;
    }

    public MongoUserDetails(String username, String password, String[] authorities) {
        this.username = username;
        this.password = password;
        grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
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
