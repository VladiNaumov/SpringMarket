package com.naumdeveloper.web.controller;

import com.naumdeveloper.web.service.ProductService;
import com.naumdeveloper.web.entities.Product;
import com.naumdeveloper.web.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/market")
    public Page<Product> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "name_part", required = false) String namePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(minPrice, maxPrice, namePart, page);

    }

    @GetMapping("/{id}")
    public Product finfId(@PathVariable Long id){
        return productService.finfById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
        product.setId(null);
        return productService.productServiceSave(product);
    }

    @PutMapping()
    public Product updateProduct(@RequestBody Product product) {
        return productService.productServiceSave(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


}
