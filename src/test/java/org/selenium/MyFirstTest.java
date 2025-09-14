package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class MyFirstTest extends BaseTest {

    @Test
    public void guestCheckout() throws InterruptedException {
        //hard-coded
        BillingAddress billingAddress = new BillingAddress("user", "demo", "San Fransisco", "San Fransisco",
                "12345", "abc@gmail.com");

        /*
        with builder pattern
        BillingAddress billingAddress = new BillingAddress().
                setFirstName("user").
                setLastName("demo").
                setAddressLine("San Fransisco").
                setCity("San Fransisco").
                setPostalCode("12345").
                setEmail("abc@gmail.com");

         */

        StorePage storePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                search("Blue");
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");

        Thread.sleep(2000);
        CartPage cartPage = storePage.clickViewCart();
        //td[class='product-name'] a
        Assert.assertEquals(cartPage.getProductName(),
                "Blue Shoes");
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
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setFirstName("user");
        billingAddress.setLastName("demo");
        billingAddress.setAddressLine("San Fransisco");
        billingAddress.setCity("San Fransisco");
        billingAddress.setPostalCode("12345");
        billingAddress.setEmail("abc@gmail.com");
        StorePage storePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                search("Blue");
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");

        Thread.sleep(2000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),
                "Blue Shoes");
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();


        checkoutPage.clickLoginBtn();
        Thread.sleep(2000);
        checkoutPage.loginAsCustomer("user", "1234").
                setBillingAddress(billingAddress).
                pause(1500).
                placeOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getSuccessNote(),
                "Thank you. Your order has been received.");
    }
}
