package com.shopping.services.Impl;

import com.shopping.entities.Book;
import com.shopping.entities.Movie;
import com.shopping.entities.Product;
import com.shopping.enums.CateroryEnum;
import com.shopping.repositories.ProductRepository;
import com.shopping.services.ProductService;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        product.setRegisterDate(new Date());
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return this.productRepository.getAllProducts();
    }

    @Override
    public void saveMaziveBooks(List<Book> products) {
        this.productRepository.saveAll(products);
    }

    @Override
    public Page<Product> getPage(Pageable pageable, String search, CateroryEnum cateroryEnum) {
        Page<Product> page = this.productRepository.getPage(pageable, search, cateroryEnum);
        page.getContent().forEach( product -> {
            product.setImageUrl(encodeBase(product.getDocument().getFile()));
        });
        return page;
    }

    @Override
    public Page<Product> getPageAll(Pageable pageable, String search, CateroryEnum cateroryEnum) {
        Page<Product> page = this.productRepository.getPageAll(pageable, search, cateroryEnum);
        page.getContent().forEach( product -> {
            product.setImageUrl(encodeBase(product.getDocument().getFile()));
        });
        return page;
    }

    @Override
    public void deleteProduct(Long id) {
        Product p = this.productRepository.getProductById(id);
        this.productRepository.delete(p);
    }

    @Override
    public Product getProduct(Long idProduct) {
        Product product = this.productRepository.getProductById(idProduct);
        return product;
    }

    @Override
    public List<Product> getProductsByIds(String ids) {
        List<Long> idsProd = new ArrayList<>();
        for (String id: ids.split(",") ) {
            idsProd.add(Long.parseLong(id));
        }
        List<Product> ret = this.productRepository.getProductByIds(idsProd);
        for (Product product: ret){
            product.setImageUrl(encodeBase(product.getDocument().getFile()));
        }
        return ret;
    }

    public String encodeBase(byte[] file){
        Base64 codec = new Base64();
        return codec.encodeAsString(file);
    }
}
