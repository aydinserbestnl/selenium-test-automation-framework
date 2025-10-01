package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void load(String endpoint) {
        driver.get("https://askomdch.com" + endpoint);
    }
}
/*
we are assigning the parameter driver to private WebDriver driver;
 */
