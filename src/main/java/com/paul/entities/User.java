package com.paul.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    //@Column(unique = true)
    private String email;
    private String password;
    private boolean active;
    private Long birthday;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('USER')")
    private UserRole authorities;
    @ManyToMany
    Set<Order> orders;

    public User() { }

    public User(String first_name, String last_name, String email, String password, boolean active, Long birthday, UserRole authorities) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.active = active;
        this.birthday = birthday;
        this.orders = new HashSet<>();
        this.authorities=authorities;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public void setAuthorities(UserRole authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(last_name, user.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, last_name);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List <UserRole> authority = new ArrayList<UserRole>();
        authority.add(this.authorities);
        return authority;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
