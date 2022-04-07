package com.example.daothymeleafpractice.dao;

import com.example.daothymeleafpractice.dto.CustomerDto;
import com.example.daothymeleafpractice.model.CustomerModel;
import com.example.daothymeleafpractice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDao {
    @Autowired
    CustomerRepository repository;

    public CustomerModel save(CustomerDto dto) {
        return repository.save(new CustomerModel(
                dto.getId(),
                dto.getName(),
                dto.getUsername(),
                dto.getCountry(),
                dto.getCity()
        ));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CustomerModel get(Long id) {
        return repository.getById(id);
    }

    public List<CustomerModel> getAll() {
        return repository.findAll();
    }

    public List<CustomerModel> getAllByUsername(String username) {
        return repository.findAllByUsername(username);
    }
    public List<CustomerModel> getAllByCountry(String country) {
        return repository.findAllByCity(country);
    }
    public List<CustomerModel> getAllByCity(String city) {
        return repository.findAllByCity(city);
    }
}
