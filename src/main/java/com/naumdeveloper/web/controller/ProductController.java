package com.naumdeveloper.web.controller;

import com.naumdeveloper.web.dto.ProductDto;
import com.naumdeveloper.web.service.ProductService;
import com.naumdeveloper.web.entities.Product;
import com.naumdeveloper.web.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minScore,
            @RequestParam(name = "max_price", required = false) Integer maxScore,
            @RequestParam(name = "name_part", required = false) String namePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(minScore, maxScore, namePart, page);

    }



    @GetMapping("/market")
    public List<Product> getAllProdukts() {
        return productService.getAllProdukts();
    }

    @PostMapping("/market")
    public void addNewProduct(@RequestBody Product product) {
        productService.productServiceSave(product);
    }


    @GetMapping("/market/ptodots_between")
    public List<Product> findSProdoctsByPriceBetween(@RequestParam(defaultValue = "0") Double min, @RequestParam(defaultValue = "100") Double max) {
        return productService.findPriceMinMax(min, max);
    }


    @GetMapping("/market/findId/{id}")
    public Product finfId(@PathVariable Long id){
        return productService.finfById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @GetMapping("/market/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    // GET http://localhost:8189/app/hello?a=10&b=20
    @GetMapping("/summa")
    public Integer helloWork(@RequestParam Integer a, @RequestParam Integer b) {
        return  a + b ;
    }

}
