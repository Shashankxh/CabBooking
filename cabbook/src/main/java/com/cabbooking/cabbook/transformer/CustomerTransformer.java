package com.cabbooking.cabbook.transformer;

import com.cabbooking.cabbook.dto.request.CustomerRequest;
import com.cabbooking.cabbook.dto.responce.CustomerResponce;
import com.cabbooking.cabbook.model.customer;

public class CustomerTransformer {
    public static customer dtoToModel(CustomerRequest custmerRequest){
        return customer.builder()
                .name(custmerRequest.getName())
                .email(custmerRequest.getEmail())
                .age(custmerRequest.getAge())
                .gender(custmerRequest.getGender())
                .build();
    }
    public static CustomerResponce modelToDto(customer Customer){
        return CustomerResponce.builder().name(Customer.getName())
                .email(Customer.getEmail())
                .gender(Customer.getGender())
                .age(Customer.getAge())
                .dateRegestredon(Customer.getDateRegestredon()).build();
    }
 }
