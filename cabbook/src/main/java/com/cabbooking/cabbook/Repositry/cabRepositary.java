package com.cabbooking.cabbook.Repositry;

import com.cabbooking.cabbook.model.cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface cabRepositary extends JpaRepository<cab,Integer> {
    @Query(value = "select * from cab where avalable = TRUE order by RANDOM() limit 1 ",nativeQuery = true)
    cab getAvalablecab();
}
