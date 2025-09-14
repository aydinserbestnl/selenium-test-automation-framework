package org.selenium.hashcode;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public StorePage goToStore() {
        return new StorePage(driver);
    }
}
