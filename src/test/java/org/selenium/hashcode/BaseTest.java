package org.selenium.hashcode;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void startDriver() {
        driver = new DriverManager().initializeDriver();
        System.out.println("BaseTest driver hash: " + driver.hashCode());
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        if (driver != null) driver.quit();
    }
}
