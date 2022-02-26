package com.iprobe.product.Model.Entity;


import com.iprobe.product.Model.dto.ProductDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products_ayse")
@Data
public class Product {
    @Id //id column'unun primary key alanı olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.AUTO) //primary keyin otomatik artacağını belirtir.
    private long id;
    @Column(name = "product_name")
    private String name;
    private double price;
    private String imageUrl;
    //entity'den dto'ya çevirmek için aşağıdaki methodu yazdık
    public ProductDTO toProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.getId());
        productDTO.setName(this.getName());
        productDTO.setPrice(this.getPrice());
        productDTO.setImageUrl(this.getImageUrl());
        return productDTO;
    }


}
