package com.mystoreapp.storeapp.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.mystoreapp.storeapp.user.Permission.*;


@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(Set.of(ADMIN_READ,ADMIN_WRITE,ADMIN_UPDATE,ADMIN_DELETE,MANAGER_READ,MANAGER_WRITE,MANAGER_UPDATE,MANAGER_DELETE)),
    MANAGER(Set.of(ADMIN_READ,ADMIN_WRITE,ADMIN_UPDATE,ADMIN_DELETE,MANAGER_READ))
    ;
    @Getter
    private final Set<Permission> permissions;

    List<SimpleGrantedAuthority> getAuthority(){
        List<SimpleGrantedAuthority> authorities = permissions
                .stream()
                .map(permission ->new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return authorities;

    }
    }
