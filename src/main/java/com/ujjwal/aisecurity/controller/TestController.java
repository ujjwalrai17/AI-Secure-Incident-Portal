
package com.ujjwal.aisecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/user")
    public String user(){

        return "Hello User!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){

        return "Hello Admin!";
    }

    @GetMapping("/analyst")
    @PreAuthorize("hasRole('ANALYST')")
    public String analyst(){

        return "Hello Analyst!";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String manager(){

        return "Hello Manager!";
    }
}