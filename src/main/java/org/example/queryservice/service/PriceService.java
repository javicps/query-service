package org.example.queryservice.service;

import org.example.queryservice.PriceResponse;
import org.example.queryservice.model.Price;
import org.example.queryservice.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public PriceResponse getApplicablePrice(String productId, Long brandId, LocalDateTime date) {
        List<Price> prices = priceRepository.findApplicablePricesForProduct(productId, brandId, date);
        if (!prices.isEmpty()) {
            Price price = prices.get(0);
            return new PriceResponse(
                    price.getProductId(),
                    price.getBrandId(),
                    price.getPriceList(),
                    date,
                    price.getPrice()
            );
        }
        return null;
    }
}
