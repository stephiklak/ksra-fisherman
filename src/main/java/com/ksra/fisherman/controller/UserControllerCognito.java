package com.ksra.fisherman.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerCognito {

    @GetMapping("/api/users1")
    public String getUser(@AuthenticationPrincipal OidcUser user) {
        if (user == null) {
            return "Not authenticated";
        }
        return "Welcome " + user.getFullName() + " (" + user.getEmail() + ")";
    }

    @GetMapping("/public/logout-success")
    public String logoutSuccess() {
        return "You have been logged out successfully.";
    }
}
