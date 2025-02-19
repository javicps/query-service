package org.example.queryservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private int priceList;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "priority")
    private int  priority;

    @Column(name = "price")
    private double price;

    @Column(name = "curr")
    private String curr;

    public int getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public String getProductId() {
        return productId;
    }

    public int getPriority() {
        return priority;
    }

    public double getPrice() {
        return price;
    }

    public String getCurr() {
        return curr;
    }
}

