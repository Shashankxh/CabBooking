package com.cabbooking.cabbook.controller;

import com.cabbooking.cabbook.dto.request.cabrequest;
import com.cabbooking.cabbook.dto.responce.CabResponse;
import com.cabbooking.cabbook.model.cab;
import com.cabbooking.cabbook.service.cabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cab")
public class cabController {
    @Autowired
    cabService cabservice;
    @PostMapping
    public ResponseEntity addCab(@RequestBody cabrequest cabRequest){
        CabResponse cabresponce =    cabservice.addCab(cabRequest);
        return new ResponseEntity(cabresponce, HttpStatus.CREATED);
    }
}
