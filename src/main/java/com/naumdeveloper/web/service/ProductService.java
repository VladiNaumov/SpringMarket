package com.naumdeveloper.web.service;

import com.naumdeveloper.web.dto.ProductDto;
import com.naumdeveloper.web.entities.Product;
import com.naumdeveloper.web.exceptions.ResourceNotFoundException;
import com.naumdeveloper.web.repository.ProductRepository;
import com.naumdeveloper.web.repository.specifications.ProductSpecifications;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> findAll(Integer minPrice, Integer maxPrice, String partName, Integer page) {
        Specification<Product> spec = Specification.where(null);
        // select s from Product s where true
        if (minPrice != null) {
            spec = spec.and(ProductSpecifications.scoreGreaterOrEqualsThan(minPrice));
            //select s from Product s where true AND s.price > minPrice
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.scoreLessThanOrEqualsThan(maxPrice));
            // select s from Product s where true AND s.price > minPrice AND s.price < maxPrice
        }
        if (partName != null) {
            spec = spec.and(ProductSpecifications.nameLike(partName));
            // select s from Product s where true AND s.price > minPrice AND s.name LIKE %partName%
        }

        return productRepository.findAll(spec, PageRequest.of(page - 1, 50));
    }

    public Optional<Product> finfById(Long id){
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
    @Transient
    public Product update(ProductDto productDto){
        Product product = productRepository.findById(productDto.getId()).orElseThrow(()->
                new ResourceNotFoundException("не возможно обновить продукт , не найден в BD, id: " + productDto.getId()));
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        return product;
    }


}
