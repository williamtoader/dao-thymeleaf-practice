package com.example.daothymeleafpractice.controllers;

import com.example.daothymeleafpractice.dao.CustomerDao;
import com.example.daothymeleafpractice.dao.OrderDao;
import com.example.daothymeleafpractice.dao.OrderDetailsDao;
import com.example.daothymeleafpractice.dao.ProductDao;
import com.example.daothymeleafpractice.model.CustomerModel;
import com.example.daothymeleafpractice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DemoController{
    @Autowired
    CustomerDao customerDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderDetailsDao orderDetailsDao;

    @Autowired
    AuthService authService;

    @GetMapping("display/orders")
    public ModelAndView displayOrders(
            @CookieValue(value = "USERNAME", defaultValue = "") String authUsername,
            @CookieValue(value = "SESSION_ID", defaultValue = "") String authSession
    ){
        if(authUsername.equals("") || authSession.equals("")) return null;
        if(!authService.checkSession(authUsername, UUID.fromString(authSession)))
            return null;
        ModelAndView modelAndView = new ModelAndView("display-orders");
        modelAndView.addObject("orders", orderDao.getAll());
        return modelAndView;
    }

    @GetMapping("display/customers")
    public ModelAndView displayCustomers(
            @CookieValue(value = "USERNAME", defaultValue = "") String authUsername,
            @CookieValue(value = "SESSION_ID", defaultValue = "") String authSession,
            @Nullable @RequestParam Long id,
            @Nullable @RequestParam String country,
            @Nullable @RequestParam String city,
            @Nullable @RequestParam String username
    ){
        if(authUsername.equals("") || authSession.equals("")) return null;
        if(!authService.checkSession(authUsername, UUID.fromString(authSession)))
            return null;
        List<CustomerModel> customerModels;

        if(id != null) {
            customerModels = new ArrayList<>();
            customerModels.add(customerDao.get(id));
        } else if(country != null) {
            customerModels = customerDao.getAllByUsername(country);
        } else if(city != null) {
            customerModels = customerDao.getAllByCity(city);
        } else if(username != null) {
            customerModels = customerDao.getAllByCountry(username);
        } else {
            customerModels = customerDao.getAll();
        }
        ModelAndView modelAndView = new ModelAndView("display-customers");
        modelAndView.addObject("customers", customerModels);
        return modelAndView;
    }
}
