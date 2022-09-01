package com.naumdeveloper.web.service;

import com.naumdeveloper.web.entities.Product;
import com.naumdeveloper.web.repository.ProductRepository;
import com.naumdeveloper.web.repository.specifications.ProductSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> find(Integer minScore, Integer maxScore, String partName, Integer page) {
        Specification<Product> spec = Specification.where(null);
        if (minScore != null) {
            spec = spec.and(ProductSpecifications.scoreGreaterOrEqualsThan(minScore));
        }
        if (maxScore != null) {
            spec = spec.and(ProductSpecifications.scoreLessThanOrEqualsThan(maxScore));
        }
        if (partName != null) {
            spec = spec.and(ProductSpecifications.nameLike(partName));
        }

        return productRepository.findAll(spec, PageRequest.of(page - 1, 5));
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
