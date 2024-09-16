package com.cabbooking.cabbook.Repositry;
import com.cabbooking.cabbook.model.driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepositry extends JpaRepository<driver,Integer>{
    driver findByPhn(long phn);
    List<driver> findByAgeAndName(int age,String name);
}
