package com.bolun;

public class BuyXItemGetYItemForFreeOffer implements IOffer {

    private int xItem;
    private int yItem;

    public BuyXItemGetYItemForFreeOffer(int xItem, int yItem) {
        this.xItem = xItem;
        this.yItem = yItem;
    }

    @Override
    public void applyOffer(Product product) {
        if (product.getQuantity() >= xItem) {
            int freeProductQty = product.getQuantity() / (xItem + yItem);
            double unitPrice = product.getPrice() / product.getQuantity();
            double discount = unitPrice * freeProductQty;
            product.setPrice(product.getPrice() - discount);
        }
    }
}
