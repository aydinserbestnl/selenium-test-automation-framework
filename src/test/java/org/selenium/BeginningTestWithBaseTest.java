package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class BeginningTestWithBaseTest extends BaseTest {
    @Test
    public void guestCheckout() throws InterruptedException {
        // We inherit an initialized WebDriver from BaseTest (protected field).
        // BaseTest creates it in @BeforeMethod by calling:
        //   new DriverManager().initializeDriver();
        // Here we pass that driver into the Page Object (dependency injection).
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
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        //builder pattern
        checkoutPage.
                enterFirstName("user").
                enterLastName("demo").
                enterAddressFld("San Fransisco").
                enterCityFld("San Fransisco").
                enterPostCodeFld("12345").
                enterEmail("abc@gmail.com").
                pause(1500).
                placeOrder();

        Thread.sleep(2000);
        Assert.assertEquals(checkoutPage.getSuccessNote(),
                "Thank you. Your order has been received.");
    }
    @Test
    public void loginAndCheckout() throws InterruptedException, AWTException {
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
                enterFirstName("user").
                enterLastName("demo").
                enterAddressFld("San Fransisco").
                enterCityFld("San Fransisco").
                enterPostCodeFld("12345").
                enterEmail("abc@gmail.com").
                pause(1500).
                placeOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getSuccessNote(),
                "Thank you. Your order has been received.");
    }
}
