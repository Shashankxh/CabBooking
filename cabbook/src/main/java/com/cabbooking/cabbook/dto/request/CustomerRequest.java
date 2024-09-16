package com.cabbooking.cabbook.dto.request;


import com.cabbooking.cabbook.enumm.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerRequest {
    String name;
    String email;
    Gender gender;
   int age;
}
