package com.example.daothymeleafpractice.controllers;

import com.example.daothymeleafpractice.dao.CustomerDao;
import com.example.daothymeleafpractice.dao.OrderDao;
import com.example.daothymeleafpractice.dao.OrderDetailsDao;
import com.example.daothymeleafpractice.dao.ProductDao;
import com.example.daothymeleafpractice.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("display/orders")
    public ModelAndView displayOrders(){
        ModelAndView modelAndView = new ModelAndView("display-orders");
        modelAndView.addObject("orders", orderDao.getAll());
        return modelAndView;
    }

    @GetMapping("display/customers")
    public ModelAndView displayCustomers(
            @Nullable @RequestParam Long id,
            @Nullable @RequestParam String country,
            @Nullable @RequestParam String city,
            @Nullable @RequestParam String username){
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
