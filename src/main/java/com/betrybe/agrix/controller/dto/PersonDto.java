package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * PersonDto.
 */
public record PersonDto(Long id, String username, Role role) {
    
}
