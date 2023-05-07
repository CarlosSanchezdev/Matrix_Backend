package com.matrix.pruebabackend.repository;

import com.matrix.pruebabackend.model.Price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Prices p WHERE :date BETWEEN p.START_DATE AND p.END_DATE AND p.product.id = :productId AND p.brand.id = :brandId")
    static List<Price> findByBrandIdAndProductIdAndDate(
            @Param("date") LocalDateTime date, @Param("productId") Integer productId, @Param("brandId") Integer brandId) {
        return null;
    }


}
