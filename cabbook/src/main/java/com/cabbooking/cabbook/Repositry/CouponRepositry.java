package com.cabbooking.cabbook.Repositry;

import com.cabbooking.cabbook.model.coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepositry extends JpaRepository<coupon,Integer> {

}
