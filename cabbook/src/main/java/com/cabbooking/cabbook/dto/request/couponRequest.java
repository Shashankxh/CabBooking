package com.cabbooking.cabbook.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class couponRequest {
    String couponCode;

    double percentageDiscount;
}
