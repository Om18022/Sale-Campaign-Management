package com.example.sale.SaleRepo;

import com.example.sale.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProRepo extends JpaRepository<Product, Long> {
}
