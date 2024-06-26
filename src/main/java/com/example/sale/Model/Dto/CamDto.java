package com.example.sale.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CamDto {
    String startDate;
    String endDate;
    String title;
    List<ProSale> discount;
}

