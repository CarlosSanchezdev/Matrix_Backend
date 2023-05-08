package com.matrix.pruebabackend.service;

import com.matrix.pruebabackend.DTO.ResponseDTO;
import com.matrix.pruebabackend.model.Brand;
import com.matrix.pruebabackend.model.Price;
import com.matrix.pruebabackend.repository.BrandRepository;
import com.matrix.pruebabackend.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    private PriceRepository priceRepository;


    public Optional<Brand> validateBrand(String brandName) {
        Optional<Brand> brandId = brandRepository.findByName(brandName);
        return brandId;
    }

    public ResponseDTO searchPrice(LocalDateTime date, Integer productId, Integer brandId) {
        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(brandId, productId, date, date);

        Price price = prices.stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new IllegalArgumentException(
                        "No applicable prices found for brandId " + brandId + ", productId " + productId + ", applicationDate " + date));

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setProductId(price.getProductId());
        responseDTO.setBrandId(price.getBrandId());
        responseDTO.setPrice(price.getPrice());
        responseDTO.setDate(date);
        responseDTO.setPriceList(price.getPriceList());

        return responseDTO;
    }

}
