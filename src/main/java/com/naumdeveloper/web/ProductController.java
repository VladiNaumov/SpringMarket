package com.naumdeveloper.web;

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

    @GetMapping("/market/findId/{id}")
    public void finfId(@PathVariable Long id){
        productService.finfById(id);
    }

    @GetMapping("/market/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/market/price/")
    public  List<Product> deleteById() {
       return productService.priceMinMax();
    }

    // GET http://localhost:8189/app/products?productId=1&delta=20
    @PostMapping("/products")
    public void addNewProduct(@RequestBody Product product) {
        productService.add(product);
    }

    // GET http://localhost:8189/app/hello?a=10&b=20
    @GetMapping("/hello")
    public Integer helloWork(@RequestParam Integer a, @RequestParam Integer b) {
        return  a + b ;
    }



}
