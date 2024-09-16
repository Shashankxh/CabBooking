package com.cabbooking.cabbook.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class driverRequest {
    String name;
    String email;
    Long phn;
    int age;
}
