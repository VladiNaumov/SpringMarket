package com.naumdeveloper.web;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProdukts() {
        return productRepository.findAll();
    }

    public Optional<Product> finfById(Long id){
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    public void productServiceSave(Product product) {
        productRepository.save(product);
    }

    public  List<Product>findPriceMinMax(Double min, Double max){
        return productRepository.findAllByPriceBetween(min, max);
    }


}
