package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    public WebDriver initializeDriver() {
        // Create ChromeOptions object
        ChromeOptions options = new ChromeOptions();

        // Add the preference to disable password leak detection
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);



        WebDriver driver = new ChromeDriver(options);
        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
/*
// Initialize the ChromeDriver with the configured options
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
 */
