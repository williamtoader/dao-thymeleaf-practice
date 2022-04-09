package com.example.daothymeleafpractice.controllers;

import com.example.daothymeleafpractice.dto.AuthEntityDto;
import com.example.daothymeleafpractice.services.AuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.util.UUID;

@Controller
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/login")
    public String login(HttpServletResponse response, AuthEntityDto authEntityDto){
        if(authService.validateLogin(authEntityDto)) {
            UUID sessionId = authService.startSession(authEntityDto.getUsername());
            response.addCookie(authService.setCookieSecurity(new Cookie("SESSIONID", sessionId.toString())));
            response.addCookie(authService.setCookieSecurity(new Cookie("USERNAME", authEntityDto.getUsername())));
            return "Successful login.";
        }
        return "Failed login.";
    }

    @PostMapping("/register")
    public String register(AuthEntityDto dto) {
        if(authService.addUser(dto))
            return "User registered successfuly.";
        return "Could not register user";
    }


}
