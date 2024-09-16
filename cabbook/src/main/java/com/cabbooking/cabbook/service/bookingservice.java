package com.cabbooking.cabbook.service;

import com.cabbooking.cabbook.Repositry.CoustomerRepositry;
import com.cabbooking.cabbook.Repositry.DriverRepositry;
import com.cabbooking.cabbook.Repositry.bookingRepositry;
import com.cabbooking.cabbook.Repositry.cabRepositary;
import com.cabbooking.cabbook.dto.request.bookingRequest;
import com.cabbooking.cabbook.dto.responce.bookingResponse;
import com.cabbooking.cabbook.exeption.CabNotFound;
import com.cabbooking.cabbook.exeption.CoustomerNotfound;
import com.cabbooking.cabbook.model.booking;
import com.cabbooking.cabbook.model.cab;
import com.cabbooking.cabbook.model.customer;
import com.cabbooking.cabbook.model.driver;
import com.cabbooking.cabbook.transformer.BookingTrasformer;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class bookingservice {
    @Autowired
    CoustomerRepositry coustomerrepositry;
    @Autowired
    cabRepositary cabrepositry;
    @Autowired
    bookingRepositry bookingrepositry;
    @Autowired
    DriverRepositry driverrepositry;
    @Autowired
    JavaMailSender javaMailSender;

    public bookingResponse getbooking(bookingRequest bookingrequest) {
        customer Customer = coustomerrepositry
                .getByEmail(bookingrequest.getCoustomeremail());
        if(ObjectUtils.isEmpty(Customer)){
            throw new CoustomerNotfound("Does not Exist of invalid email");
        }
        cab Cab = cabrepositry.getAvalablecab();
        if(ObjectUtils.isEmpty(Cab)){
            throw new CabNotFound("Cab not available at This moment !");
        }
        driver Driver = Cab.getDrivers();
        booking Booking = BookingTrasformer.dtoToModel(bookingrequest,Cab);
        Booking.setCustomer(Customer);
        Booking.setDrivers(Driver);
        booking Savedbooking = bookingrepositry.save(Booking);
        Customer.getBook().add(Savedbooking);
        Driver.getBookings().add(Savedbooking);
        Cab.setAvalable(false);
        coustomerrepositry.save(Customer);
        driverrepositry.save(Driver);
        sendMail(Savedbooking);
        return BookingTrasformer.modeToDto(Savedbooking);
    }
    private void sendMail(booking savedbooking){
        String text =" Hi! " + savedbooking.getCustomer().getName()+" your Booking is confermed"
                + " The Booking Id is : " + savedbooking.getBookingId() + " BookedAt "+
                savedbooking.getBookedAt();
        SimpleMailMessage smiplemailmassage = new SimpleMailMessage();
        smiplemailmassage.setFrom("chanksharu@gmail.com");
        smiplemailmassage.setTo(savedbooking.getCustomer().getEmail());
        smiplemailmassage.setSubject("Cab Booked !");
        smiplemailmassage.setText(text);
        javaMailSender.send(smiplemailmassage);
    }
}
