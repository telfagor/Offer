package com.bolun;

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {

    private final List<Product> productList = new ArrayList<>();
    IOffer offer;

    public void addProduct(Product product) {
        if (offer != null) {
            offer.applyOffer(product);
        }
        productList.add(product);
    }

    public int getProductCount() {
        return productList.size();
    }

    public double getTotalValues() {
        return productList.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }


    public void setOffer(IOffer offer) {
        this.offer = offer;
    }

    public Product getProductByName(String name) {
        if (!productList.isEmpty()) {
            for (Product product : productList) {
                if (product.getName().equals(name)) {
                    return product;
                }
            }
        }
        return null;
    }
}
