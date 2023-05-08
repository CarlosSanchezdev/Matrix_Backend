package com.matrix.pruebabackend.repository;

import com.matrix.pruebabackend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
    Optional<Brand> findByName(String name);
}
