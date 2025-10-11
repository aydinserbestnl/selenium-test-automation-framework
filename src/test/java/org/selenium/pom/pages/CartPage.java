package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
    private final By productName = By.cssSelector(".product-name a");
    //private final By checkOutBtn = By.cssSelector(".checkout-button");
    //@FindBy(css = ".checkout-button") private WebElement checkOutBtn;
    @FindBy(how = How.CSS, using = ".checkout-button")
    @CacheLookup private WebElement checkOutBtn; //it will use the cashed version whenever it is needed
    //instead of fetching the element from api-ui

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getProductName() {
        return driver.findElement(productName).getText();
    }
    public CheckoutPage clickCheckoutBtn() {
        //driver.findElement(checkOutBtn).click();
        checkOutBtn.click();
        return new CheckoutPage(driver);
    }
}
