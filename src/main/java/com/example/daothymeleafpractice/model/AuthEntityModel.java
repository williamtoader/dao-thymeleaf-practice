package com.example.daothymeleafpractice.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
public class AuthEntityModel {
    @Id
    private String username;

    private String passwordHash;

    private UUID activeSession;

    private java.sql.Date activeSessionExpiryDate;

    public UUID getActiveSession() {
        return activeSession;
    }

    public Date getActiveSessionExpiryDate() {
        return activeSessionExpiryDate;
    }

    public void setActiveSession(UUID activeSession) {
        this.activeSession = activeSession;
        this.activeSessionExpiryDate = Date.valueOf(LocalDate.now().plus(24, ChronoUnit.HOURS));
    }



    @Transient
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public Boolean validatePassword(String plainTextPassword) {
        return passwordEncoder.matches(plainTextPassword, this.passwordHash);
    }

    public void setPassword(String plainTextPassword) {
        this.passwordHash = passwordEncoder.encode(plainTextPassword);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}