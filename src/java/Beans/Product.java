/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author c0645743
 */
public class Product {

    public int productid;
    public String name;
    public String description;

    public int quantity;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product() {
    }

    public Product(int id, String na, String desc, int qunt) {

        productid = id;
        name = na;
        description = desc;
        quantity = qunt;

    }

    public void consumeJSON(JsonObject json) {
        productid = json.getInt("productid");
        name = json.getString("name");
        description = json.getString("description");
        quantity = json.getInt("quantity");
    }

    public JsonObject toJSON() {

        JsonObject json = Json.createObjectBuilder().add("productid", productid).add("name", name).add("description", description).add("quantity", quantity).build();

        return json;

    }

}
