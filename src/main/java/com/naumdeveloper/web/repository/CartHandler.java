package com.naumdeveloper.web.repository;

import com.naumdeveloper.web.entities.Cart;
import com.naumdeveloper.web.entities.Product;

import java.util.List;

public class CartHandler {
   private Cart cart;

    public void addProducToCart(Product product){
        cart.getPurchase().add(product);
        cart.setPrice(product.getPrice());
        cart.setQuantity(cart.getPurchase().size());
        System.out.println(cart.getPurchase());
    }

    public void deleting(long id){
        List<Product> cartProduct = cart.getPurchase();
        for (Product p : cartProduct ) {
            if(p.getId().equals(id)){
                cartProduct.remove(id);
            }
        }
    }

    public void clear(){
        cart.getPurchase().clear();
    }
}
