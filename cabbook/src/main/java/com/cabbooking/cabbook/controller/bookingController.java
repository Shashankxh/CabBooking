package com.cabbooking.cabbook.controller;

import com.cabbooking.cabbook.dto.request.bookingRequest;
import com.cabbooking.cabbook.dto.responce.bookingResponse;
import com.cabbooking.cabbook.service.bookingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/cab/booking")
public class bookingController {
@Autowired
    bookingservice BookingService;
@PostMapping
public ResponseEntity getbooking(@RequestBody bookingRequest bookingrequest){
    bookingResponse br = BookingService.getbooking(bookingrequest);
    return new ResponseEntity(br, HttpStatus.CREATED);
}
}
