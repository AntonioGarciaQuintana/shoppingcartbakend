package com.shopping.controllers;

import com.shopping.entities.Sale;
import com.shopping.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sale")
@CrossOrigin("*")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping(path = "/saveSale")
    public ResponseEntity saveSale(@RequestBody Sale sale){
        Sale ret = this.saleService.saveSale(sale);
        return ResponseEntity.ok(ret);
    }

}
