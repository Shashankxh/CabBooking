package com.cabbooking.cabbook.model;

import com.cabbooking.cabbook.enumm.bookingstatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId; // UUID

    String pickUp;

    String destination;

    @CreationTimestamp
    Date bookedAt;  // both date and time - Util

    @UpdateTimestamp
    Date updatedAt;

    double totalFare;

    double totalDistance;

    bookingstatus status;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    customer Customer;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    driver drivers ;
}
