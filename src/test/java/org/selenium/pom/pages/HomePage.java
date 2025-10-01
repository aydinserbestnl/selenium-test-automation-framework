package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    //we are going to click store link -menü on the home page
    public StorePage navigateToStoreUsingMenu() {
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
    public HomePage load() {
        load("/");
        wait.until(ExpectedConditions.titleContains("AskOmDch"));

        return this;
    }
}
/*
using super keyword we are passing driver to the constructor of the BasePage,
so this way , the driver in the basePage is getting set by the homepage
 */
