package com.cabbooking.cabbook.Repositry;

import com.cabbooking.cabbook.model.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CoustomerRepositry extends JpaRepository<customer,Integer> {

    @Query(value = "select c from customer c where c.name = :name and c.age >= :age")
        List<customer> getByNameandAgelargerthen(String name, int age);

    customer getByEmail(String email);

}
