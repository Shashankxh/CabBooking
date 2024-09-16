package com.cabbooking.cabbook.controller;

import com.cabbooking.cabbook.dto.request.driverRequest;
import com.cabbooking.cabbook.dto.responce.driverResponce;
import com.cabbooking.cabbook.model.driver;
import com.cabbooking.cabbook.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cab/driver")
public class DriverController {
   @Autowired
    DriverService driverservice;
    @PostMapping
    public ResponseEntity addDriver(@RequestBody driverRequest driverrequest) {
        return new ResponseEntity(driverservice.addDriver(driverrequest),HttpStatus.CREATED);
    }
    @GetMapping
    public driverResponce getdriver(@RequestParam("driverId") int driverid) {
        return driverservice.getdriver(driverid);
    }
    @GetMapping("/phn")
    public driverResponce getdriver(@RequestParam("phn") long phn){
        return driverservice.getdriver(phn);
    }
    @GetMapping("/age{age}-and-name{name}")
    public List<driverResponce> getdeiver(@PathVariable int age,@PathVariable String name ){
        return driverservice.getdriver(age,name);
    }

}
