package com.example.sale.Controller;

import com.example.sale.Model.Dto.ProDto;
import com.example.sale.Model.Product;
import com.example.sale.Services.ProServ;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProController {
    @Autowired
    public ProServ proServ;

    @PostMapping("saveall")
    public List<Product> save(@RequestBody List<Product> products){
        return proServ.save(products);
    }

    @GetMapping("getall")
    public ProDto getall(@RequestParam int page, @RequestParam int pageSize){
        return proServ.getall(page, pageSize);
    }
}
