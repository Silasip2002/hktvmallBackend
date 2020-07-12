package com.hktv.productAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
@SecondaryTable(name="location", pkJoinColumns = @PrimaryKeyJoinColumn(name = "productCode"))
public class Product {
    @Id
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private float weight;
    @Column(name = "location", table = "location")
    private String location;
    @Column(name = "quantity", table = "location")
    private int quantity;

    public Product() {
    }

    public Product(String code, String name, float weight, String location, int quantity) {
        this.code = code;
        this.name = name;
        this.weight = weight;
        this.location = location;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String  location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int  quantity) {
        this.quantity = quantity;
    }
}

