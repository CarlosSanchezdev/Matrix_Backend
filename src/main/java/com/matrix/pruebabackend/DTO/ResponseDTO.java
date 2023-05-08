package com.matrix.pruebabackend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO {

    private Integer productId;
    private Integer brandId;
    private BigDecimal price;
    private LocalDateTime date;
    private Integer priceList;

}
