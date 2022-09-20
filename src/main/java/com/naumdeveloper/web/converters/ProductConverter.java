package com.naumdeveloper.web.converters;

import com.naumdeveloper.web.dto.ProductDto;
import com.naumdeveloper.web.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }
}
