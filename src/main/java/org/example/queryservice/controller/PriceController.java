package org.example.queryservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.queryservice.PriceResponse;
import org.example.queryservice.exception.PriceNotFoundException;
import org.example.queryservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping
    public PriceResponse getApplicablePrice(
            @RequestParam String productId,
            @RequestParam int brandId,
            @RequestParam String date) throws JsonProcessingException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        PriceResponse priceResponse = priceService.getApplicablePrice(productId, brandId, dtf.parse(date, LocalDateTime::from));
        if (priceResponse == null) {
            throw new PriceNotFoundException("No applicable price found for product ID: " + productId);
        }
        return priceResponse;
    }

}
