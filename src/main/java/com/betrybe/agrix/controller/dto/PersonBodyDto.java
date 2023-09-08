package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * PersonBodyDto.
 */
public record PersonBodyDto(String username, String password, Role role) {
    
}
