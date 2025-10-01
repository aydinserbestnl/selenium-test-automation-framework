package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("#woocommerce_product_search-1 > form > button");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");


    private StorePage enterTextToTheSearchField(String text) {
        driver.findElement(searchFld).sendKeys(text);
        return this;
    }
    public boolean isLoaded() {
        return wait.until(ExpectedConditions.urlContains("/store"));
    }
    private StorePage clickSearchBtn() {
        driver.findElement(searchBtn).click();
        return this;
    }
    public StorePage search(String text) {
//        driver.findElement(searchFld).sendKeys(text);
//        driver.findElement(searchBtn).click();
        enterTextToTheSearchField(text).clickSearchBtn();
        return this;
    }
    public String getTitle() {
        return driver.findElement(title).getText();
    }
    private By clickAddToCartBtnElement(String productName) {
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }
    public StorePage clickAddToCartBtn(String product) {
        By addToCartBtn = clickAddToCartBtnElement(product);
        driver.findElement(addToCartBtn).click();
        return this;
    }
    public CartPage clickViewCart() {
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }
}
