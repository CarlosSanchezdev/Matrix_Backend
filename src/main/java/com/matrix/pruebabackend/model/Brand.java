package com.matrix.pruebabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Integer id;

    @Column (name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brandId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Price> prices;

}
