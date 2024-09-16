package com.cabbooking.cabbook.service;

import com.cabbooking.cabbook.Repositry.CouponRepositry;
import com.cabbooking.cabbook.dto.request.couponRequest;
import com.cabbooking.cabbook.model.coupon;
import com.cabbooking.cabbook.transformer.CouponTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
@Autowired
    CouponRepositry couponrepositry;
    public String addCoupon(couponRequest couponrequest) {
        coupon c = CouponTransformer.dtoToModel(couponrequest);
        couponrepositry.save(c);
        return "all set";
    }
}
