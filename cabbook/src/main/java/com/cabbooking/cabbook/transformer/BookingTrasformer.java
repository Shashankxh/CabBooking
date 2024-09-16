package com.cabbooking.cabbook.transformer;

import com.cabbooking.cabbook.dto.request.bookingRequest;
import com.cabbooking.cabbook.dto.responce.bookingResponse;
import com.cabbooking.cabbook.enumm.bookingstatus;
import com.cabbooking.cabbook.model.booking;
import com.cabbooking.cabbook.model.cab;

import java.util.UUID;

public class BookingTrasformer {
    public static booking dtoToModel( bookingRequest bookingrequest, cab Cab){
        return booking.builder().bookingId(String.valueOf(UUID.randomUUID()))
                .pickUp(bookingrequest.getPickUp())
                .destination(bookingrequest.getDestination())
                .totalFare(Cab.getFareKM()*bookingrequest.getTotaldistance())
                .totalDistance(bookingrequest.getTotaldistance())
                .status(bookingstatus.BOOKED)
        .build();
    }
    public static bookingResponse modeToDto(booking book){
        return bookingResponse.builder()
                 .bookingId(book.getBookingId())
                .bookedAt(book.getBookedAt())
                .destination(book.getDestination()).pickUp(book.getPickUp())
                .updatedAt(book.getUpdatedAt())
                .totalFare(book.getTotalFare())
                .totalDistance(book.getTotalDistance())
                .status(book.getStatus())
                .cabr(cabTransformer.modelToDto(book.getDrivers().getCab()))
                .dr(driverTransformer.modelToDto(book.getDrivers()))
                .cr(CustomerTransformer.modelToDto(book.getCustomer()))
        .build();
    }
}
