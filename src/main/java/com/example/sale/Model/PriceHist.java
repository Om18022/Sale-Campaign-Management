package com.example.sale.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PriceHist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    double price;
    long productId;
}
