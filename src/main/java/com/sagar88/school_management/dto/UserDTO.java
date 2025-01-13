package com.sagar88.school_management.dto;

import com.sagar88.school_management.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private UserRole role;
    private String password;
}
