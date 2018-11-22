package com.shopping.services.Impl;

import com.shopping.entities.Book;
import com.shopping.entities.Movie;
import com.shopping.entities.Product;
import com.shopping.entities.User;
import com.shopping.enums.CateroryEnum;
import com.shopping.repositories.ProductRepository;
import com.shopping.services.ProductService;
import com.shopping.services.UserService;
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
    private UserService userService;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository, UserService userService){
        this.productRepository = productRepository;
        this.userService = userService;
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
        saveDefaultAdmin();
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

    public void saveDefaultAdmin(){
        User userAdmin = new User();
        userAdmin.setRole("ADMIN");
        userAdmin.setFullName("Administrator");
        userAdmin.setUsername("admin@pinnacle.com");
        userAdmin.setPassword("admin");

        User userClient = new User();
        userClient.setRole("USER");
        userClient.setFullName("Client defaul");
        userClient.setUsername("clientdefault@pinnacle.com");
        userClient.setPassword("default");

        User existUserAdmin = this.userService.getUserByUserName("admin@pinnacle.com");
        User existUserClient = this.userService.getUserByUserName("clientdefault@pinnacle.com");
        if(existUserAdmin == null){
            this.userService.saveUser(userAdmin);
        }
        if(existUserClient == null){
            this.userService.saveUser(userClient);
        }

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
