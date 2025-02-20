package org.example.queryservice.controller;

import org.example.queryservice.exception.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ResultActions getPerform(String productId, String brandId, String date) throws Exception {
        return mockMvc.perform(get("/api/prices")
                .param("productId", productId)
                .param("brandId", brandId)
                .param("date", date));
    }

    @Test
    public void testPriceAtDay14Hour10for35455is35and50() throws Exception {
        {
            getPerform("35455", "1", "2020-06-14 10:00:00")
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(35.50));
        }
    }

    @Test
    public void testPriceAtDay14Hour16for35455is25and45() throws Exception {
        {
            getPerform("35455", "1", "2020-06-14 16:00:00")
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(25.45));
        }
    }

    @Test
    public void testPriceAtDay14Hour21for35455is35and50() throws Exception {
        {
            getPerform("35455", "1", "2020-06-14 21:00:00")
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(35.50));
        }
    }

    @Test
    public void testPriceAtDay15Hour10for35455is35and50() throws Exception {
        {
            getPerform("35455", "1", "2020-06-15 10:00:00")
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(30.50));
        }
    }

    @Test
    public void testPriceAtDay16Hour21for35455is38and95() throws Exception {
        {
            getPerform("35455", "1", "2020-06-16 21:00:00")
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(38.95));
        }
    }

    @Test
    public void testPriceAtYear2021ReturnsNotFoundException() throws Exception {
        {
            getPerform("35455", "1", "2021-06-16 21:00:00")
                    .andExpect(status().isNotFound())
                    .andExpect(result -> assertInstanceOf(PriceNotFoundException.class, result.getResolvedException()));
        }
    }

    @Test
    public void testPriceWithUnknownBrandReturnsNotFound() throws Exception {
        {
            getPerform("35455", "4", "2020-06-16 21:00:00")
                    .andExpect(status().isNotFound())
                    .andExpect(result -> assertInstanceOf(PriceNotFoundException.class, result.getResolvedException()));
        }
    }
}
