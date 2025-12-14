package org.selenium.pom.tests;

import org.junit.Assert;
import org.junit.Test;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;

import java.awt.*;
import java.io.IOException;

public class MyFirstTest extends BaseTest {

   // @Test
    @Test
    public void guestCheckout() throws IOException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        StorePage storePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu();
        storePage.isLoaded();
        storePage.
                search(searchFor);
        //Assert.assertEquals(storePage.getTitle(),"Search results: “"+searchFor+"”");
        Assert.assertEquals("Search results: “"+searchFor+"”", storePage.getTitle());

        storePage.clickAddToCartBtn(product.getName());
        CartPage cartPage = storePage.clickViewCart();
        //td[class='product-name'] a
        Assert.assertEquals(product.getName(), cartPage.getProductName());

        CheckoutPage checkoutPage = cartPage.
                clickCheckoutBtn().
                setBillingAddress(billingAddress).
                pause(1500).
                placeOrder();
        Assert.assertEquals("Thank you. Your order has been received.",
                checkoutPage.getSuccessNote());
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
        Assert.assertEquals("Search results: “"+searchFor+"”", storePage.getTitle());
        storePage.clickAddToCartBtn("Blue Shoes");
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals("Blue Shoes",
                cartPage.getProductName());
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();


        checkoutPage.clickLoginBtn();
        checkoutPage.loginAsCustomer(user).
                setBillingAddress(billingAddress).
                pause(1500).
                placeOrder();
        Assert.assertEquals("Thank you. Your order has been received.",
                checkoutPage.getSuccessNote());
    }
}
