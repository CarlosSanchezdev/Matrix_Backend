package com.matrix.pruebabackend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SearchDTO {

    private String name;

    private LocalDateTime date;

    private String productName;

}
