package com.sagar88.school_management.service.serviceimpl;

import com.sagar88.school_management.entity.User;
import com.sagar88.school_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    //Maybe use constructor injection instead of filed
    //As of this implementation, UserDetailsServiceImpl needs to be passed profileRepository for instantiation
    //Is @Autowired and constructor injection both necessary
    @Autowired
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Error: User not found for the email: " + email));

        return UserDetailsImpl.build(user);
    }
}
