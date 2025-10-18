package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    @Parameters("browser")
    public void startDriver(@Optional("chrome") String browser) {
        System.setProperty("browser", browser);
        setDriver(new DriverManager().initializeDriver(browser));
        System.out.println("THREAD " + Thread.currentThread().threadId()
                + " -> " + getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        WebDriver current = getDriver();
        if (current != null) {
            current.quit();
            setDriver(null); // ThreadLocal'ı temizlemek için
        }
    }
}
