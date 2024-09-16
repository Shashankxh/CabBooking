package com.cabbooking.cabbook.service;
import com.cabbooking.cabbook.exeption.driverNotFound;
import com.cabbooking.cabbook.transformer.driverTransformer;
import com.cabbooking.cabbook.Repositry.DriverRepositry;
import com.cabbooking.cabbook.dto.request.driverRequest;
import com.cabbooking.cabbook.dto.responce.driverResponce;
import com.cabbooking.cabbook.model.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    DriverRepositry driverrepository;

    public driverResponce addDriver( driverRequest driverrequest) {
        driver Driver = driverTransformer.dtoToModel(driverrequest);
        driver Saveddriver = driverrepository.save(Driver);
        return driverTransformer.modelToDto(Saveddriver);
    }
    public driverResponce getdriver(int driverid){
        Optional<driver> opdriver = driverrepository.findById(driverid);
        if(opdriver.isEmpty()){
            throw new driverNotFound("invelid id");
        }
        driver Driver = opdriver.get();
        return driverTransformer.modelToDto(Driver);
    }
    public driverResponce getdriver(long phn){
        Optional<driver> opdrivr = Optional.ofNullable(driverrepository.findByPhn(phn));
        if(opdrivr.isEmpty()){
            throw new driverNotFound("invalid phn");
        }
        driver Driver = opdrivr.get();
        return driverTransformer.modelToDto(Driver);

    }
    public List<driverResponce> getdriver(int age,String name){
        List<driver> Driver = driverrepository.findByAgeAndName(age,name);
        List<driverResponce> driverresponce = new ArrayList<>();
        for(driver drivers: Driver){
            driverresponce.add(driverTransformer.modelToDto(drivers));
        }
        return driverresponce;
    }

}
