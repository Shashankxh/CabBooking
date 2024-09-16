package com.cabbooking.cabbook.model;

import com.cabbooking.cabbook.enumm.Cabtype;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
@Entity
@Builder
public class cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String carname;

    String carmodel;
@Enumerated(EnumType.STRING)
    Cabtype Cabtype;

    double fareKM;

    Boolean avalable;
    @OneToOne
    @JoinColumn
    @JsonIgnore
    driver drivers;
}
