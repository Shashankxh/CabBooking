package com.cabbooking.cabbook.controller;


import com.cabbooking.cabbook.dto.request.couponRequest;
import com.cabbooking.cabbook.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/Coupon")
public class CouponController {
   @Autowired
   CouponService couponservice;
   @PostMapping
   public ResponseEntity addCoupon(@RequestBody couponRequest couponrequest){
      String re = couponservice.addCoupon(couponrequest);
      return new ResponseEntity(re, HttpStatus.CREATED);
   }
}
