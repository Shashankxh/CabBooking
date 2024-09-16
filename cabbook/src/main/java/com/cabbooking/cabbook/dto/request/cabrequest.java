package com.cabbooking.cabbook.dto.request;

import com.cabbooking.cabbook.enumm.Cabtype;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class cabrequest {
    String carname;
    String carmodel;
    double fareKM;
    Cabtype cabtype;
    long phn;
}
