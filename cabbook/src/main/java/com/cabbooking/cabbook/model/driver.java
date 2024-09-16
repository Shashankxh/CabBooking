package com.cabbooking.cabbook.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.web.WebProperties;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String email;
    @Column(unique = true,nullable = false)
    Long phn;
    int age;
    @OneToMany(mappedBy = "drivers", cascade = CascadeType.ALL)
    List<booking> bookings = new ArrayList<>();
    @OneToOne(mappedBy = "drivers", cascade = CascadeType.ALL)
    cab Cab;

}
