package com.iprobe.product.Model.dto;

import com.iprobe.product.Model.Entity.Product;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ProductDTO {
    @Min(value = 0, message = "Product id must be greater than or equal to 0")
    private long id;
    @NotBlank(message = "Product name is mandatory")
    private  String Name;
    @DecimalMin(value = "0.00", inclusive = false, message = "Product price must be greater than 0.00")
    private double price;
    private String imageUrl;
    //aşağıdaki method dtodan entity dönüşümü için yazılmıştır.
    public Product toProduct(){
        Product product=new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setPrice(this.getPrice());
        product.setImageUrl(this.getImageUrl());

    return product;
    }
}
