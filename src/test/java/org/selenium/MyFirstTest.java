package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class MyFirstTest extends BaseTest {

    @Test
    public void guestCheckout() throws InterruptedException, IOException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        StorePage storePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                search(searchFor);
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitle(),"Search results: “"+searchFor+"”");
        storePage.clickAddToCartBtn(product.getName());

        Thread.sleep(2000);
        CartPage cartPage = storePage.clickViewCart();
        //td[class='product-name'] a
        Assert.assertEquals(cartPage.getProductName(),
                product.getName());
        CheckoutPage checkoutPage = cartPage.
                clickCheckoutBtn().
                setBillingAddress(billingAddress).
                pause(1500).
                placeOrder();

        Thread.sleep(2000);
        Assert.assertEquals(checkoutPage.getSuccessNote(),
                "Thank you. Your order has been received.");
    }
    @Test
    public void loginAndCheckout() throws InterruptedException, AWTException {
        String searchFor = "Blue";
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setFirstName("user");
        billingAddress.setLastName("demo");
        billingAddress.setAddressLine("San Fransisco");
        billingAddress.setCity("San Fransisco");
        billingAddress.setPostalCode("12345");
        billingAddress.setEmail("abc@gmail.com");

        User user = new User("ueser", "demo");
        StorePage storePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                search(searchFor);
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitle(),"Search results: “"+searchFor+"”");
        storePage.clickAddToCartBtn("Blue Shoes");

        Thread.sleep(2000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),
                "Blue Shoes");
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();


        checkoutPage.clickLoginBtn();
        Thread.sleep(2000);
        checkoutPage.loginAsCustomer(user).
                setBillingAddress(billingAddress).
                pause(1500).
                placeOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getSuccessNote(),
                "Thank you. Your order has been received.");
    }
}
