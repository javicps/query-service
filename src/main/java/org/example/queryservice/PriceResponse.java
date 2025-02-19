package org.example.queryservice;

import org.example.queryservice.controller.PriceController;

import java.time.LocalDateTime;

public class PriceResponse {

    private String productId;
    private int brandId;
    private int priceList;
    private LocalDateTime applicableDate;
    private double finalPrice;

    public PriceResponse(String productId, int brandId, int priceList, LocalDateTime applicableDate, double finalPrice ) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.applicableDate = applicableDate;
        this.finalPrice = finalPrice;
    }

    public String getProductId() {
        return productId;
    }

    public int getBrandId() {
        return brandId;
    }

    public int getPriceList() {
        return priceList;
    }

    public LocalDateTime getApplicableDate() {
        return applicableDate;
    }

    public double getFinalPrice() {
        return finalPrice;
    }
}
