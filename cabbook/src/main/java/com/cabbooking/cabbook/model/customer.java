package com.cabbooking.cabbook.model;

import com.cabbooking.cabbook.enumm.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class customer
{
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    @Column(unique = true,nullable = false )
    String email;
    @Enumerated(EnumType.STRING)
    Gender gender;
    int age;
    @CreationTimestamp
    Date dateRegestredon;
    @OneToMany(mappedBy = "Customer", cascade = CascadeType.ALL)
    List<booking> book = new ArrayList<>();

}
