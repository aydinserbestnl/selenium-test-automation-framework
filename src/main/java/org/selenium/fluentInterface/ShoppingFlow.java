package org.selenium.fluentInterface;

//Burada hem method chaining var,
//hem de kod bir senaryo gibi okunuyor →
// “Mağazaya git, ürün ekle, checkout’a ilerle, siparişi ver.”

public class ShoppingFlow {
    public ShoppingFlow goToStore(){
        System.out.println("Navigated to Store page");
        return this;
    }
    public ShoppingFlow addItem(String item) {
        System.out.println("Added item: " + item);
        return this;
    }
    public ShoppingFlow proceedToCheckout() {
        System.out.println("Proceeded to Checkout");
        return this;
    }
    public ShoppingFlow placeOrder() {
        System.out.println("Order placed!");
        return this;
    }
}
