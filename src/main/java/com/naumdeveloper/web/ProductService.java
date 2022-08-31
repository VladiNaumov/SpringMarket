package com.naumdeveloper.web;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProdukts() {
        return productRepository.findAll();
    }

    public void finfById(Long id){
        productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    public void add(Product product) {
        productRepository.save(product);
    }

    public  List<Product>priceMinMax(){
        return productRepository.findAllByPriceBetween(1.0, 5.0);
    }
}
