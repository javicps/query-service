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

    public PriceResponse getApplicablePrice(String productId, int brandId, LocalDateTime date) {
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, brandId, date, date);

        if (!prices.isEmpty()) {
            Price priceOutput = prices.stream().findFirst().orElse(null);
            return new PriceResponse(
                    priceOutput.getProductId(),
                    priceOutput.getBrandId(),
                    priceOutput.getPriceList(),
                    date,
                    priceOutput.getPrice()
            );
        }
        return null;
    }
}
