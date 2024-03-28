package com.example.sale.SaleRepo;

import com.example.sale.Model.PriceHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceHistRepo extends JpaRepository<PriceHist, Long> {
}
