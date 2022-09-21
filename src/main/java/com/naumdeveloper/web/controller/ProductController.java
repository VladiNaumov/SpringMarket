package com.naumdeveloper.web.controller;

import com.naumdeveloper.web.converters.ProductConverter;
import com.naumdeveloper.web.dto.ProductDto;
import com.naumdeveloper.web.service.ProductService;
import com.naumdeveloper.web.entities.Product;
import com.naumdeveloper.web.exceptions.ResourceNotFoundException;
import com.naumdeveloper.web.validators.ProductValidator;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;

    private final ProductValidator productValidator;

    public ProductController(ProductService productService, ProductConverter productConverter, ProductValidator productValidator) {
        this.productService = productService;
        this.productConverter = productConverter;
        this.productValidator = productValidator;
    }
    @GetMapping()
    public Page<ProductDto> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "name_part", required = false) String namePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(minPrice, maxPrice, namePart, page)
                .map(productConverter::entityToDto);

    }

    @GetMapping("/{id}")
    public ProductDto getProductId(@PathVariable Long id){
        Product product = productService.finfById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return productConverter.entityToDto(product);
    }

    @PostMapping()
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productService.save(product);
        return productConverter.entityToDto(product);
    }

    @PutMapping()
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productService.update(productDto);
        return productConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


}
