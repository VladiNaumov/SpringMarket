package com.naumdeveloper.web.entities;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
   private  List<Product> purchase;
   private String title;
   private int quantity;
   private Double price;

   @PostConstruct
   private void createCart(){
       purchase = new ArrayList<>();
   }

    public List<Product> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Product> purchase) {
        this.purchase = purchase;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
