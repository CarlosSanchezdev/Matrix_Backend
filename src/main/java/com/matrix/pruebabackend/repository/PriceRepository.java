package com.matrix.pruebabackend.repository;

import com.matrix.pruebabackend.model.Price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    List<Price>findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(
            Integer brandId,
            Integer productId,
            LocalDateTime startDate,
            LocalDateTime endDate);

}
