package com.naumdeveloper.web;

import com.naumdeveloper.web.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/market/")
    public List<Product> getAllProdukts() {
        return productService.getAllProdukts();
    }

    // GET http://localhost:8189/app/products?name=1&price=20
    @PostMapping("/products")
    public void addNewProduct(@RequestBody Product product) {
        productService.add(product);
    }

    @GetMapping("/market/ptodots_between")
    public List<Product> findSProdoctsByScoreBetween(@RequestParam(defaultValue = "0") Double min, @RequestParam(defaultValue = "100") Double max) {
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
