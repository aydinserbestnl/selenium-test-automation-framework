package org.selenium.pom.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;

public class BaseTest {
    //private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected WebDriver driver;
//    private void setDriver(WebDriver driver) {
//        this.driver.set(driver);
//    }
//
//    protected WebDriver getDriver() {
//        return this.driver.get();
//    }

    @Before
    public void startDriver() {
        String browser = System.getProperty("browser");
        //String browser = "FIREFOX";
        driver = new DriverManager().initializeDriver(browser);
        System.out.println("THREAD " + Thread.currentThread().threadId()
                + " -> " + driver);
    }

    @After()
    public void quitDriver() {

        System.out.println("THREAD " + Thread.currentThread().threadId()
                + " -> " + driver);
        driver.quit();
    }

}
