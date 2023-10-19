package com.mystoreapp.storeapp.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),

    MANAGER_READ("manager:read"),
    MANAGER_WRITE("manager:write"),
    MANAGER_UPDATE("manager:update"),
    MANAGER_DELETE("manager:delete")
    ;



    @Getter
    private final String permission;
}

