package com.bolun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void testCreateEmptyShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals(0, shoppingCart.getProductCount());
    }

    @Test
    public void addSingleProductToTheShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("Gatsby Hair Cream", 1, 30.0);
        shoppingCart.addProduct(product);
        assertEquals(1, shoppingCart.getProductCount());
        assertEquals(30.0, shoppingCart.getTotalValues());
    }

    @Test
    public void addDifferentProductsToTheShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product1 = new Product("Gatsby Hair Cream", 1, 30);
        Product product2 = new Product("Bvlgiri Soap", 1, 100);
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);
        assertEquals(2, shoppingCart.getProductCount());
        assertEquals(130, shoppingCart.getTotalValues());
    }

    @Test
    public void addMultipleQuantityOfAProductAndApplyOfferToCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        BuyXItemGetYItemForFreeOffer offer = new BuyXItemGetYItemForFreeOffer(2,1);
        Product product1 = new Product("Gatsby hair cream", 5, 150.0);
        shoppingCart.setOffer(offer);
        shoppingCart.addProduct(product1);
        assertEquals(1, shoppingCart.getProductCount());
        assertEquals(120.0, shoppingCart.getTotalValues());
    }

    @Test
    public void addDifferentProductsAndApplyOfferToTheCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        IOffer offer = new BuyXItemGetYItemForFreeOffer(2, 1);
        shoppingCart.setOffer(offer);
        Product gatsByCream = new Product("Gatsby hair cream", 3, 90.0);
        Product bvlgireSoap = new Product("Bvlgiri Soap", 2, 200.0);
        shoppingCart.addProduct(gatsByCream);
        shoppingCart.setOffer(new NoOffer());
        shoppingCart.addProduct(bvlgireSoap);
        assertEquals(2, shoppingCart.getProductCount());
        assertEquals(260.0, shoppingCart.getTotalValues());
    }

    @Test
    public void applyBuyOneGetFiftyPercentDiscountOnNextOffer() {
        IOffer offer = new DiscountOnNextItemOffer(50.0);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product gatsByCream = new Product("Gatsby hair cream", 2, 60.0);
        cart.addProduct(gatsByCream );
        assertEquals(1, cart.getProductCount());
        assertEquals(45.0, cart.getProductByName("Gatsby hair cream").getPrice(),0.0);
        assertEquals(45.0, cart.getTotalValues(),0.0);
    }

    @Test
    public void testApplyBuyOneGetFiftyPercentDiscountOnNextOfferToTheMultipleProductsInCart(){
        IOffer offer = new DiscountOnNextItemOffer(50.0);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product gatsByCream = new Product("Gatsby hair cream", 5, 150.0);
        cart.addProduct(gatsByCream);
        assertEquals(1, cart.getProductCount());
        assertEquals(120.0, cart.getProductByName("Gatsby hair cream").getPrice(),0.0);
        assertEquals(120.0, cart.getTotalValues(),0.0);
    }
}
