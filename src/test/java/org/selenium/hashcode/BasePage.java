package org.selenium.hashcode;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        System.out.println(getClass().getSimpleName() + " driver hash: " + driver.hashCode());
    }
}
