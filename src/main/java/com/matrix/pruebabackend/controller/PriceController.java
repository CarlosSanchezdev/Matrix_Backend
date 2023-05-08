package com.matrix.pruebabackend.controller;

import com.matrix.pruebabackend.DTO.SearchDTO;
import com.matrix.pruebabackend.model.Brand;
import com.matrix.pruebabackend.service.SearchService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    public SearchService searchService;

    @GetMapping("")
    public Optional<Object> readStory(@RequestBody @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) SearchDTO searchDTO) {
       Optional<Brand> optionalBrand = searchService.validateBrand(searchDTO.getName());
        if (optionalBrand.isPresent()) {
            Brand brand = optionalBrand.get();
            return Optional.ofNullable(searchService.searchPrice(searchDTO.getDate(), searchDTO.getProductId(), brand.getId()));
        } else {
            // Si no se encontró la marca, devolver un valor nulo
            return Optional.empty();
        }
    }

}
