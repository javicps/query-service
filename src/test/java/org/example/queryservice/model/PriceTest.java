package org.example.queryservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class PriceTest {

    @Test
    public void testGettersAndSetters() {
        Price price = new Price();

        // Sample values
        price.setId(1L);
        price.setBrandId(1);
        price.setProductId("35455");
        price.setPriceList(1);
        price.setPriority(0);
        price.setPrice(35.50);
        price.setCurr("EUR");
        price.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        price.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));

        // Assertions
        assertEquals(1L, price.getId());
        assertEquals(1, price.getBrandId());
        assertEquals("35455", price.getProductId());
        assertEquals(1, price.getPriceList());
        assertEquals(0, price.getPriority());
        assertEquals(35.50, price.getPrice());
        assertEquals("EUR", price.getCurr());
        assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0), price.getStartDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59), price.getEndDate());
    }
}
