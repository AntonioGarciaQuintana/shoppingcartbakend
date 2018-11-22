package com.shopping.services;

import com.shopping.entities.Sale;
import org.springframework.stereotype.Service;

@Service
public interface SaleService {

    Sale saveSale(Sale sale);
}
