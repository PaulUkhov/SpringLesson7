package org.example.spring7homework2.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
@RequestMapping("/api/resource")
public class ResourceController {

    @GetMapping("/auth/public-data/book")
    public String auth() {
        return "Authorized";
    }

    @GetMapping("/user/reader")
    @PreAuthorize("hasAnyAuthority('ROLE_READER')")
    public String user() {
        return "User";
    }

    @GetMapping("/admin/issue/private-data")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String admin() {
        return "Admin";
    }
}
