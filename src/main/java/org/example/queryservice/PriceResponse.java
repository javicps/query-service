package org.example.queryservice;

import java.time.LocalDateTime;

public record PriceResponse(String productId, int brandId, int priceList, LocalDateTime applicableDate,
                            double finalPrice) {

}
