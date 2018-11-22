package com.shopping.controllers;

import com.shopping.dtos.TransferProduct;
import com.shopping.entities.Book;
import com.shopping.entities.Movie;
import com.shopping.entities.Product;
import com.shopping.enums.CateroryEnum;
import com.shopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping( path = "/products")
    public ResponseEntity getProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(path = "/getPageAll")
    public ResponseEntity getPageAll(Pageable pageable, String search, CateroryEnum category){
        Page<Product> page = this.productService.getPageAll(pageable, search, category);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(path = "/getPage")
    public ResponseEntity getPage(Pageable pageable, String search, CateroryEnum category){
        Page<Product> page = this.productService.getPage(pageable, search, category);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(path = "/getProduct/{id}")
    public ResponseEntity getProduct(@PathVariable long id) {
        return  ResponseEntity.ok(this.productService.getProduct(id));
    }

    @DeleteMapping(path = "/DeleteProduct/{id}")
    public ResponseEntity DeleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping(path = "/saveProductBook")
    public ResponseEntity saveProduct( @RequestBody Book book){
        Product retProduct = this.productService.saveProduct(book);
        return ResponseEntity.ok(retProduct);
    }

    @PostMapping(path = "/saveProductMovie")
    public ResponseEntity saveProductMovie( @RequestBody Movie movie){
        Product retProduct = this.productService.saveProduct(movie);
        return ResponseEntity.ok(retProduct);
    }

    @GetMapping(path = "/getProductsByIds/{ids}")
    public ResponseEntity getProductsByIds( @PathVariable String ids) {
        List<Product> ret = this.productService.getProductsByIds(ids);
        return  ResponseEntity.ok(ret);
    }




}
