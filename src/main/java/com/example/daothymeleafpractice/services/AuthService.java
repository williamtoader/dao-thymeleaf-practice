package com.example.daothymeleafpractice.services;

import com.example.daothymeleafpractice.dto.AuthEntityDto;
import com.example.daothymeleafpractice.model.AuthEntityModel;
import com.example.daothymeleafpractice.repositories.AuthEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    AuthEntityRepository authEntityRepository;

    public final String COOKIE_SECURITY_DOMAIN = "localhost";
    public final Boolean COOKIE_SECURITY_HTTPS_ENABLE = true;

    // Max age set to 86400 seconds = 24 hours
    public final Integer COOKIE_SECURITY_MAX_AGE = 86400;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public Boolean addUser(AuthEntityDto dto) {
        if(authEntityRepository.findById(dto.getUsername()).isPresent())
            return false;
        AuthEntityModel model = new AuthEntityModel();

        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPlainTextPassword());

        authEntityRepository.save(model);
        return true;
    }

    public Boolean validateLogin(AuthEntityDto dto) {
        Optional<AuthEntityModel> modelOptional = authEntityRepository.findById(dto.getUsername());
        if(modelOptional.isPresent()) {
            AuthEntityModel user = modelOptional.get();
            return user.validatePassword(dto.getPlainTextPassword());
        }
        return false;
    }

    public Boolean checkSession(String username, UUID sessionId) {
        Optional<AuthEntityModel> modelOptional = authEntityRepository.findById(username);
        if(modelOptional.isPresent()) {
            AuthEntityModel user = modelOptional.get();
            return  user.getActiveSession().equals(sessionId) &&
                    user.getActiveSessionExpiryDate().after(Date.valueOf(LocalDate.now()));
        }
        return false;
    }

    public UUID startSession(String username) {
        Optional<AuthEntityModel> modelOptional = authEntityRepository.findById(username);
        if(modelOptional.isPresent()) {
            AuthEntityModel user = modelOptional.get();
            UUID sessionId = UUID.randomUUID();
            user.setActiveSession(sessionId);
            authEntityRepository.save(user);
            return sessionId;
        }
        return null;
    }

    public Cookie setCookieSecurity(Cookie cookie) {
        cookie.setDomain(COOKIE_SECURITY_DOMAIN);
        cookie.setSecure(COOKIE_SECURITY_HTTPS_ENABLE);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(COOKIE_SECURITY_MAX_AGE);
        return cookie;
    }
}
