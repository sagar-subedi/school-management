package com.sagar88.school_management.service;

import com.sagar88.school_management.config.JwtService;
import com.sagar88.school_management.dto.LoginDTO;
import com.sagar88.school_management.dto.LoginResponse;
import com.sagar88.school_management.dto.UserDTO;
import com.sagar88.school_management.entity.User;
import com.sagar88.school_management.repository.UserRepository;
import com.sagar88.school_management.service.serviceimpl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<LoginResponse>    login(LoginDTO loginDTO) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            String jwtToken = jwtService.generateJwtToken(authentication);

        return ResponseEntity.ok(LoginResponse.builder()
                .id(userDetails.getId())
                .email(userDetails.getEmail())
                .token(jwtToken)
                .build());
    }

    public User register(UserDTO userDTO) throws Exception {
        Optional<User>  user = userRepository.findByEmail(userDTO.getEmail());
        if (user.isPresent()) {
            throw new Exception("The email is already used by another account");
        }
        User newUser = new User();
        newUser.setEmail(userDTO.getEmail());
        newUser.setRole(userDTO.getRole());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setUsername(userDTO.getUsername());
        return userRepository.save(newUser);
    }
}
