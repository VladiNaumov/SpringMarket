package web;

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

    public void finfById(String name){
        productRepository.findByName(name);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    public void changeDiscount(Long productId, Integer delta) {
       // Product product = productRepository.findById(productId);
       // product.setDiscount(product.getDiscount() + delta);

        // studentRepository.save(student);

    }

    public void add(Product product) {


    }
}
