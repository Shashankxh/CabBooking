package com.cabbooking.cabbook.controller;

import com.cabbooking.cabbook.dto.request.CustomerRequest;
import com.cabbooking.cabbook.dto.responce.CustomerResponce;
import com.cabbooking.cabbook.model.customer;
import com.cabbooking.cabbook.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/Customer")
public class CustomerControler {
    @Autowired
    CustomerService customerservice;
    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerrequest){
        CustomerResponce customerr =  customerservice.addCustomer(customerrequest);
        return new ResponseEntity(customerr,HttpStatus.CREATED );
    }
    @GetMapping("/name-{name}-and-age-{age}")
    public ResponseEntity findNameandAge(@PathVariable String name, @PathVariable int age){
        List<CustomerResponce> show = customerservice.findNameandAge(name,age);
        return new ResponseEntity(show,HttpStatus.ACCEPTED);
    }
}
