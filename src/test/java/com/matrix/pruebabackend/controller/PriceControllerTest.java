package com.matrix.pruebabackend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.matrix.pruebabackend.DTO.SearchDTO;
import com.matrix.pruebabackend.service.SearchService;
import java.time.LocalDateTime;
import java.time.Month;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SearchService searchService;

    @Test
    public void testSearchPriceCase1() throws Exception {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setName("ZARA");
        searchDTO.setDate(LocalDateTime.of(2020, Month.JUNE, 14, 10, 0));
        searchDTO.setProductId(35455);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.date").value("2020-06-14T10:00:00"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.productId").value("35455"));
    }

    @Test
    public void testSearchPriceCase2() throws Exception {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setName("ZARA");
        searchDTO.setDate(LocalDateTime.of(2020, Month.JUNE, 14, 16, 0));
        searchDTO.setProductId(35455);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.date").value("2020-06-14T16:00:00"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.productId").value("35455"));
    }

    @Test
    public void testSearchPriceCase3() throws Exception {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setName("ZARA");
        searchDTO.setDate(LocalDateTime.of(2020, Month.JUNE, 14, 21, 0));
        searchDTO.setProductId(35455);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.date").value("2020-06-14T21:00:00"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.productId").value("35455"));
    }

    @Test
    public void testSearchPriceCase4() throws Exception {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setName("ZARA");
        searchDTO.setDate(LocalDateTime.of(2020, Month.JUNE, 15, 10, 0));
        searchDTO.setProductId(35455);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.5))
                .andExpect(jsonPath("$.date").value("2020-06-15T10:00:00"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.productId").value("35455"));
    }

    @Test
    public void testSearchPriceCase5() throws Exception {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setName("ZARA");
        searchDTO.setDate(LocalDateTime.of(2020, Month.JUNE, 16, 21, 0));
        searchDTO.setProductId(35455);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.date").value("2020-06-16T21:00:00"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.productId").value("35455"));
    }

}
