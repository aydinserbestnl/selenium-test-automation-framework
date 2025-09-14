package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

public class CheckoutPage extends BasePage {
    private final By firstNameFld = By.id("billing_first_name");
    private final By lastNameFld = By.id("billing_last_name");
    private final By addressLine = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successNote = By.cssSelector(".woocommerce-notice");
    private final By customerLoginBtn = By.className("showlogin");
    private final By userNameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public CheckoutPage enterFirstName(String name) {
        driver.findElement(firstNameFld).sendKeys(name);
        return this;
    }
    public CheckoutPage enterLastName(String lastName) {
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }
    public CheckoutPage enterCityFld(String cityName) {
        driver.findElement(billingCityFld).sendKeys(cityName);
        return this;
    }
    public CheckoutPage enterPostCodeFld(String postcode) {
        driver.findElement(billingPostCodeFld).sendKeys(postcode);
        return this;
    }
    public CheckoutPage enterAddressFld(String address) {
        driver.findElement(addressLine).sendKeys(address);
        return this;
    }
    public CheckoutPage enterEmail(String email) {
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }
    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterAddressFld(billingAddress.getAddressLine()).
                enterCityFld(billingAddress.getCity()).
                enterPostCodeFld(billingAddress.getPostalCode()).
                enterEmail(billingAddress.getEmail());
    }
    public CheckoutPage placeOrder() {
        driver.findElement(placeOrderBtn).click();
        return this;
    }
    public String getSuccessNote() {
        return driver.findElement(successNote).getText();
    }
    public CheckoutPage clickLoginBtn() {
        driver.findElement(customerLoginBtn).click();
        return this;
    }
    public CheckoutPage enterUserName(String userName) {
        driver.findElement(userNameFld).sendKeys(userName);
        return this;
    }
    public CheckoutPage enterPassword(String password) {
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }
    public CheckoutPage loginAsCustomer(String username, String password) {
        return enterUserName(username).
                enterPassword(password).
                clickLoginBtn();
    }
    public CheckoutPage pause(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return this;
    }
}
