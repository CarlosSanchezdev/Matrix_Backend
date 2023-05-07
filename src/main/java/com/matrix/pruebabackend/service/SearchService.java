package com.matrix.pruebabackend.service;

import com.matrix.pruebabackend.DTO.SearchDTO;
import com.matrix.pruebabackend.model.Brand;
import com.matrix.pruebabackend.model.Price;
import com.matrix.pruebabackend.repository.BrandRepository;
import com.matrix.pruebabackend.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

   @Autowired
    BrandRepository brandRepository;

    @Autowired
    private PriceRepository priceRepository;

    public Optional<Brand> validateBrand(String brandName){
        Optional<Brand> brandId = brandRepository.findByName(brandName);
        return brandId;
    }

    public List<Price> searchPrice(LocalDateTime date, Integer productId, Integer brandId){
        return PriceRepository.findByBrandIdAndProductIdAndDate(date, productId, brandId);
    }

}
