package org.example.queryservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPriceAtDay14Hour10for35455is35and50() throws Exception {
        {
            mockMvc.perform(get("/api/prices")
                            .param("productId", "35455")
                            .param("brandId", "1")
                            .param("date", "2020-06-14 10:00:00"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(35.50));
        }
    }

    @Test
    public void testPriceAtDay14Hour16for35455is25and45() throws Exception {
        {
            mockMvc.perform(get("/api/prices")
                            .param("productId", "35455")
                            .param("brandId", "1")
                            .param("date", "2020-06-14 16:00:00"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(25.45));
        }
    }

    @Test
    public void testPriceAtDay14Hour21for35455is35and50() throws Exception {
        {
            mockMvc.perform(get("/api/prices")
                            .param("productId", "35455")
                            .param("brandId", "1")
                            .param("date", "2020-06-14 21:00:00"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(35.50));
        }
    }

    @Test
    public void testPriceAtDay15Hour10for35455is35and50() throws Exception {
        {
            mockMvc.perform(get("/api/prices")
                            .param("productId", "35455")
                            .param("brandId", "1")
                            .param("date", "2020-06-15 10:00:00"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(30.50));
        }
    }

    @Test
    public void testPriceAtDay16Hour21for35455is38and95() throws Exception {
        {
            mockMvc.perform(get("/api/prices")
                            .param("productId", "35455")
                            .param("brandId", "1")
                            .param("date", "2020-06-16 21:00:00"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.finalPrice").value(38.95));
        }
    }

    @Test
    public void testPriceAtYear2021ReturnsNotFound() throws Exception {
        {
            mockMvc.perform(get("/api/prices")
                            .param("productId", "35455")
                            .param("brandId", "1")
                            .param("date", "2021-06-16 21:00:00"))
                    .andExpect(status().isNotFound());
        }
    }
}
