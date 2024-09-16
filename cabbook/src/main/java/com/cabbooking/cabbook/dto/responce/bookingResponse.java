package com.cabbooking.cabbook.dto.responce;

import com.cabbooking.cabbook.enumm.bookingstatus;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class bookingResponse {
    String bookingId; // UUID
    String pickUp;
    String destination;

    Date bookedAt;  // both date and time - Util

    Date updatedAt;

    double totalFare;

    double totalDistance;

    bookingstatus status;
    CustomerResponce cr;
    driverResponce dr;
    CabResponse cabr;

}
