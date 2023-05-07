package com.matrix.pruebabackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class SearchDTO {

    private String name;

    private Integer productId;

    private LocalDateTime date;


    public SearchDTO() {

    }




}
