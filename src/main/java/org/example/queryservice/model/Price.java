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
    private int brandId; // The numeric identifier for a brand

    @Column(name = "start_date")
    private LocalDateTime startDate; // starting date and time when the price is valid

    @Column(name = "end_date")
    private LocalDateTime endDate; // end date and time when the price is valid

    @Column(name = "price_list")
    private int priceList; // the price list numeric identifier

    @Column(name = "product_id")
    private String productId; // product code or SKU

    @Column(name = "priority")
    private int  priority; // priority in case two prices are applicable

    @Column(name = "price")
    private double price; // price for the product

    @Column(name = "curr")
    private String curr; // currency code associated with the price

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public long getId() {
        return id;
    }

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

