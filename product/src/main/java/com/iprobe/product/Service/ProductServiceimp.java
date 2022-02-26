package com.iprobe.product.Service;

import com.iprobe.product.Exception.NotFoundException;
import com.iprobe.product.Model.Entity.Product;
import com.iprobe.product.Model.dto.ProductDTO;
import com.iprobe.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceimp implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream()
                .map(Product::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get().toProductDTO();
        }
        else {
            throw new NotFoundException("Not found id"+ id);
        }
    }


    @Override
    public ProductDTO createProduct(ProductDTO product) {
        if (product.getId() > 0) {
            throw new RuntimeException("Product already exists");
        }
        return productRepository.save(product.toProduct()).toProductDTO();
    }
    @Override
    public ProductDTO updateProduct(ProductDTO productDto) {
       Optional<Product> product = productRepository.findById(productDto.getId());
        if(product.isPresent()){
            Product createdProduct = productRepository.save(productDto.toProduct());
            return createdProduct.toProductDTO();
        }
        else {
            throw new NotFoundException("Not found id"+ productDto.getId());
        }
    }
    @Override
    public ProductDTO deleteProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            Product tobedeleted=product.get();
            productRepository.delete(product.get());
            return tobedeleted.toProductDTO();
        }
        else {
            throw new NotFoundException("Not found id"+ id);
        }
    }
}
