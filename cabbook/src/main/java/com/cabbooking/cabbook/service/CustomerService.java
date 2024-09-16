package com.cabbooking.cabbook.service;

import com.cabbooking.cabbook.Repositry.CoustomerRepositry;
import com.cabbooking.cabbook.dto.request.CustomerRequest;
import com.cabbooking.cabbook.dto.responce.CustomerResponce;
import com.cabbooking.cabbook.model.customer;
import com.cabbooking.cabbook.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CoustomerRepositry customerRepositry;
    public CustomerResponce addCustomer(CustomerRequest customerresponce){
        customer Customer = CustomerTransformer.dtoToModel(customerresponce);
        customer SavedCustomer = customerRepositry.save(Customer);
        return CustomerTransformer.modelToDto(SavedCustomer);
    }

    public List<CustomerResponce> findNameandAge(String name, int age) {
        List<customer> Customer = customerRepositry.getByNameandAgelargerthen(name,age);
        List<CustomerResponce> cr = new ArrayList<>();
        for(customer c: Customer){
            cr.add(CustomerTransformer.modelToDto(c));
        }
        return cr;
    }
}
