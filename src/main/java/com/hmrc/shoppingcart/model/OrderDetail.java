package com.hmrc.shoppingcart.model;

/**
 * Model class holds details of orders
 * Created by Sunil on 27/01/2017.
 */
public class OrderDetail {
    private Product product;
    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
