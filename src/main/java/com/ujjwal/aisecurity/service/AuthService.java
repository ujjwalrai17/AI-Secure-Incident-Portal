
package com.ujjwal.aisecurity.service;

import com.ujjwal.aisecurity.dto.*;
import com.ujjwal.aisecurity.entity.User;
import com.ujjwal.aisecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public void register(RegisterRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .role("USER")
                .build();

        repository.save(user);
    }

    public AuthResponse login(LoginRequest request) {

        User user = repository.findByUsername(request.getUsername())
                .orElseThrow();

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponse(token);
    }
}