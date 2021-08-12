/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunnm.dtos;

import java.util.Vector;

/**
 *
 * @author PC
 */
public class ProductDTO {

    String id;
    String name;
    String unit;
    int price;
    int quantity;
    String categoryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public ProductDTO(String id, String name, String unit, int price, int quantity, String categoryId) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public ProductDTO(String id, String name, String categoryId, String unit, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "id=" + id + ", name=" + name + ", unit=" + unit + ", price=" + price + ", quantity=" + quantity + ", categoryId=" + categoryId + '}';
    }

    public Vector getVector() {
        Vector vector = new Vector();
        vector.add(this.id);
        vector.add(this.name);
        vector.add(this.unit);
        vector.add(this.price);
        vector.add(this.quantity);
        vector.add(this.categoryId);
        return vector;
    }

}
