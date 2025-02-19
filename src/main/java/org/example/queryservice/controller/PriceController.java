package org.example.queryservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.queryservice.PriceResponse;
import org.example.queryservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

System.out.println("ENTERING");
        PriceResponse priceResponse = priceService.getApplicablePrice(productId, brandId, dtf.parse(date, LocalDateTime::from));
        if (priceResponse == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Price not found for given parameters");
        }
        return priceResponse;
    }

}
