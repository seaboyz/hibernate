package com.webdev.model;

public class CartItem {
    private Product product;
    private int quantity;
    private Cart cart;

    public CartItem() {
    }

    public CartItem(Product product, int quantity, Cart cart) {
        this.product = product;
        this.quantity = quantity;
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
