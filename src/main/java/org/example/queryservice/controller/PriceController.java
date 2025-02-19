package org.example.queryservice.controller;

import org.example.queryservice.PriceResponse;
import org.example.queryservice.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/applicablePrice")
    public PriceResponse getApplicablePrice(
            @RequestParam String productId,
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat LocalDateTime date) {
        return priceService.getApplicablePrice(productId, brandId, date);
    }

}
