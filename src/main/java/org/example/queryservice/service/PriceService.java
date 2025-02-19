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
        List<Price> prices = priceRepository.findByProductIdAndBrandIdOrderByPriorityDesc(productId, brandId);
        System.out.println("prices is equal to " + prices.size());

        if (!prices.isEmpty()) {
            /*Price priceOutput = prices.stream()
                    .filter(price -> productId.equals(price.getProductId()) && price.getBrandId() == brandId
                            && date.isAfter(price.getStartDate()) && date.isBefore(price.getEndDate()))
                    .max((p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority()))
                    .orElse(null);
*/
            Price priceOutput = prices.get(0);
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
