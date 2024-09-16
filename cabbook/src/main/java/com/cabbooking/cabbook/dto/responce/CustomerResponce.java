package com.cabbooking.cabbook.dto.responce;

import com.cabbooking.cabbook.enumm.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponce {
    String name;
    String email;
    Gender gender;
    int age;
    Date dateRegestredon;
}
