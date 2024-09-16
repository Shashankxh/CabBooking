package com.cabbooking.cabbook.transformer;

import com.cabbooking.cabbook.dto.request.couponRequest;
import com.cabbooking.cabbook.model.coupon;

public class CouponTransformer {
    public static coupon dtoToModel(couponRequest couponrequest){
        return coupon.builder().couponCode(couponrequest.getCouponCode()).percentageDiscount(couponrequest.getPercentageDiscount()).build();
    }
}
