package com.shopping.services;

import com.shopping.entities.Book;
import com.shopping.entities.Product;
import com.shopping.enums.CateroryEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    Product saveProduct(Product product);

    List<Product> getAllProducts();

    void saveMaziveBooks(List<Book> products);

    Page<Product> getPage(Pageable pageable, String search, CateroryEnum cateroryEnum);

    Page<Product> getPageAll(Pageable pageable, String search, CateroryEnum cateroryEnum);

    void deleteProduct(Long id);

    Product getProduct(Long idProduct);

    List<Product> getProductsByIds(String ids);

}
