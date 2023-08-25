package com.bolun;

public class DiscountOnNextItemOffer implements IOffer {

    private double discountPercentage;

    public DiscountOnNextItemOffer(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void applyOffer(Product product) {
        int totalQuantity = product.getQuantity();
        double unitPrice = product.getPrice() / product.getQuantity();
        while (totalQuantity > 1) {
            double price = product.getPrice();
            product.setPrice(price - (unitPrice / (100 / discountPercentage)));
            totalQuantity = totalQuantity - 2;
        }
    }
}
