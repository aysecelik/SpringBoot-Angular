package com.iprobe.product.Controller;

import com.iprobe.product.Service.ProductService;
import com.iprobe.product.Model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }
    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    public ProductDTO getProductById(@PathVariable long id){
        return productService.getProduct(id);
    }
    @RequestMapping(value = "/product",method = RequestMethod.POST)
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO product){
        return productService.createProduct(product);
    }
    @RequestMapping(value = "/product",method = RequestMethod.PUT)
    public ProductDTO updateProduct(@Valid @RequestBody ProductDTO product){
        return productService.updateProduct(product);
    }
    @RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
    public ProductDTO deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }

}
