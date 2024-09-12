package com.springboot.crud.sprinboot_app.entities;


import com.springboot.crud.sprinboot_app.validation.IsExistsDb;
import com.springboot.crud.sprinboot_app.validation.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{NotBlank.product.name}") //NotEmpty es para STRINGS
    private String name;
    @Min(value = 1,message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}") //NotNull es para todos menos STRING
    private Integer price;
    @IsRequired
    private String description;
    @IsExistsDb
    @IsRequired
    private String sku;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
