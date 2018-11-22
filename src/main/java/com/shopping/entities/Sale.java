package com.shopping.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table( name = "tbl_sale")
public class Sale {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn( name = "id_sale")
    private  List<DetailSale> detailSale;

    @OneToOne()
    private User user;

    private BigDecimal total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DetailSale> getDetailSale() {
        return detailSale;
    }

    public void setDetailSale(List<DetailSale> detailSale) {
        this.detailSale = detailSale;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
