package com.sagar88.schoolmanagement.dto;

import com.sagar88.schoolmanagement.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private UserRole role;
    private String password;
}
