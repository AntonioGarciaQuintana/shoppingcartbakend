package com.shopping.services.Impl;

import com.shopping.entities.Sale;
import com.shopping.repositories.SaleRepository;
import com.shopping.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;

    @Autowired
    SaleServiceImpl( SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale saveSale(Sale sale) {
        return this.saleRepository.save(sale);
    }
}
