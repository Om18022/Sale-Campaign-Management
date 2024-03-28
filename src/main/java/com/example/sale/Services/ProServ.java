package com.example.sale.Services;

import com.example.sale.Model.Dto.ProDto;
import com.example.sale.Model.Product;
import com.example.sale.SaleRepo.ProRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ProServ {
    @Autowired
    public ProRepo proRepo;

    public List<Product> save(List<Product> products){
        return proRepo.saveAll(products);
    }

    public ProDto getall(int page, int pageSize){
        Page<Product> productPage = proRepo.findAll(PageRequest.of(page-1, pageSize));

        List<Product> productList =productPage.getContent();
        int totalPage = ((Page<?>)productPage).getTotalPages();
    
        ProDto a = new ProDto();
        a.setProducts(productList);
        a.setPage(page);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);

        return a;
    }
}
