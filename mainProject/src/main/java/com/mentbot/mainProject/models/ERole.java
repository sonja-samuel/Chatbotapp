package com.mentbot.mainProject.models;

public enum ERole {

    ROLE_DOCTOR, ROLE_ADMIN, ROLE_PATIENT;

    public static ERole getERole (String roleName) {
        if (roleName == null) {
            return null;
        }
        if (roleName.isEmpty()) {
            return null;
        }
        for (ERole role: ERole.values()) {
         if (role.name().equals(roleName)) {
             return role;
         }
        }
        return null;
    }

}
