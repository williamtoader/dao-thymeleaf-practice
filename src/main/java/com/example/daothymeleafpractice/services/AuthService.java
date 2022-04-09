package com.example.daothymeleafpractice.services;

import com.example.daothymeleafpractice.dto.AuthEntityDto;
import com.example.daothymeleafpractice.model.AuthEntityModel;
import com.example.daothymeleafpractice.repositories.AuthEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    AuthEntityRepository authEntityRepository;

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
}
