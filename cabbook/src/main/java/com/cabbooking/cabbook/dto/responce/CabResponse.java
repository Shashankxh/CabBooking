package com.cabbooking.cabbook.dto.responce;

import com.cabbooking.cabbook.enumm.Cabtype;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CabResponse {
    String carname;
    String carmodel;
    Cabtype cabtype;
    double fareKM;
    Boolean avalable;
}
