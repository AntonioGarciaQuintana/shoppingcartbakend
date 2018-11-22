package com.shopping.entities;

import com.shopping.enums.CateroryEnum;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table( name = "tbl_product")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="product_type", discriminatorType = DiscriminatorType.STRING)
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "category")
    private CateroryEnum category;

    @Min(1)
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private int stock;

    @NotNull
    @Column(name = "registerDate")
    private Date registerDate;

    @OneToOne
    private Document document;

    @NotNull
    @Column(name = "active")
    private boolean active;

    @Transient
    private String imageUrl;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CateroryEnum getCategory() {
        return category;
    }

    public void setCategory(CateroryEnum category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}

