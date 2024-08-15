package com.johnabbott.OnlineBookstoreMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "accessDeny";
    }
}
