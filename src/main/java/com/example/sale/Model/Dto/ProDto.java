package com.example.sale.Model.Dto;

import com.example.sale.Model.Product;
import lombok.Data;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Data
public class ProDto {
    private List<Product> products;
    private int page;
    private int pageSize;
    private int totalPage;
}
