package org.example.queryservice.repository;

import org.example.queryservice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findApplicablePricesForProduct(String productId, Long brandId, LocalDateTime applicableDate);
}
