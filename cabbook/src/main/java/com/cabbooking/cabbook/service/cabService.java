package com.cabbooking.cabbook.service;

import com.cabbooking.cabbook.dto.request.cabrequest;
import com.cabbooking.cabbook.dto.responce.CabResponse;
import com.cabbooking.cabbook.exeption.driverNotFound;

import com.cabbooking.cabbook.Repositry.DriverRepositry;
import com.cabbooking.cabbook.Repositry.cabRepositary;
import com.cabbooking.cabbook.model.cab;
import com.cabbooking.cabbook.model.driver;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cabbooking.cabbook.transformer.cabTransformer;

import java.util.Optional;


@Service
public class cabService {
    @Autowired
    DriverRepositry driverRepositry;
    @Autowired
    cabRepositary cabrepositary;
    public CabResponse addCab(cabrequest cabRequest){
       cab Cab = cabTransformer.dtoToModel(cabRequest);


        driver driverOptional = driverRepositry.findByPhn(cabRequest.getPhn());
        if(ObjectUtils.isEmpty(driverOptional)){
            throw new driverNotFound("inveled id");
        }
       // driverOptional.setCab(Cab);

        Cab.setDrivers(driverOptional);
        Cab.setAvalable(true);
        driverRepositry.save(driverOptional);
        cab Savedcab = cabrepositary.save(Cab);
        return cabTransformer.modelToDto(Savedcab);
    }

}
