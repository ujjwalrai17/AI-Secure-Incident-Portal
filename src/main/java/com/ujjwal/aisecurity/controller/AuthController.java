
package com.ujjwal.aisecurity.controller;

import com.ujjwal.aisecurity.dto.*;
import com.ujjwal.aisecurity.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        service.register(request);

        return "User Registered Successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        return service.login(request);
    }
}



