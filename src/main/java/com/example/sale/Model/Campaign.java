package com.example.sale.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String title;
    public String startDate;
    public String endDate;
    public double discount;
    public long productId;
    public double oldprice;
    public String formattedTime;

    @PrePersist
    public void prepersist(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
        this.formattedTime = sdf.format(new Date(System.currentTimeMillis()));
    }
}
