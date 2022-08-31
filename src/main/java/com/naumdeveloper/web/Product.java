package com.naumdeveloper.web;

import javax.persistence.*;

@Entity
@Table(name = "product" )
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount")
    private Integer discount;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        if(discount < 100 && discount > -1 ){
            this.discount = discount;
        }
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if(price > 0){
            this.price = price;
        }
    }

    public Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        this.discount = 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
