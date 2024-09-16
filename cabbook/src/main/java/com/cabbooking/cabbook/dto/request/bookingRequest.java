package com.cabbooking.cabbook.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class bookingRequest {
   // String bookingId;
    String pickUp;
    String destination;
    String coustomeremail;
    double totaldistance;

}
