package com.mezo.athena.demain;

public enum RoleEnum {

    ADMIN(0),
    OPERATION(1),
    GUEST(9);
    private Integer id;
    private RoleEnum(Integer id) {
        this.id = id;
    }

}
