package com.cabbooking.cabbook.transformer;

import com.cabbooking.cabbook.dto.request.driverRequest;
import com.cabbooking.cabbook.dto.responce.driverResponce;
import com.cabbooking.cabbook.model.driver;

public class driverTransformer {
    public static driver dtoToModel(driverRequest driverrequest){
        return driver.builder().name(driverrequest.getName()).age(driverrequest.getAge())
                .email(driverrequest.getEmail()).phn(driverrequest.getPhn()).build();

    }
    public static driverResponce modelToDto(driver Driver){
        return driverResponce.builder().name(Driver.getName()).email(Driver.getEmail()).phn(Driver.getPhn()).build();
    }
}
