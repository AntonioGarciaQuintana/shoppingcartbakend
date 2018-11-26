package com.shopping.repositories;

import com.shopping.entities.Product;
import com.shopping.enums.CateroryEnum;
import jdk.nashorn.internal.ir.LiteralNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT P FROM Product P ")
    List<Product> getAllProducts();

    @Query("SELECT P FROM Product P " +
            "WHERE (P.name LIKE CONCAT('%',:search,'%') " +
            "AND (:category IS NULL OR  P.category = :category) )" +
            "AND P.active = true and P.delete = false")
    Page<Product> getPage(Pageable pageable, @Param("search") String search, @Param("category") CateroryEnum cateroryEnum);

    @Query("SELECT P FROM Product P " +
            "WHERE P.name LIKE CONCAT('%',:search,'%') " +
            "AND (:category IS NULL OR  P.category = :category) " +
            "AND P.delete = false")
    Page<Product> getPageAll(Pageable pageable, @Param("search") String search, @Param("category") CateroryEnum cateroryEnum);

    @Query("SELECT P FROM Product P WHERE P.id = :idProduct")
    Product getProductById(@Param("idProduct") Long idProduct);

    @Query("SELECT P FROM Product P WHERE P.id in (:idProducts)")
    List<Product> getProductByIds(@Param("idProducts") List<Long> idProducts);
}
