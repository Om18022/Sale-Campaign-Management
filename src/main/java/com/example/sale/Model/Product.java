package com.example.sale.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String dcr;
    double mrp;
    double cp;
//    double dics;
    int inventory;
    String formattedTime;

    @PrePersist
    public void prePersist(){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    this.formattedTime = sdf.format(new Date(System.currentTimeMillis()));
    }
}

