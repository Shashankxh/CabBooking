package com.cabbooking.cabbook.Repositry;

import com.cabbooking.cabbook.model.booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookingRepositry extends JpaRepository<booking,Integer> {
}
