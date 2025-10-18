package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.selenium.pom.constants.BrowserType;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    public WebDriver initializeDriver(String browser) {
        WebDriver driver = createDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    private WebDriver createDriver(String browser) {
        return switch (BrowserType.valueOf(browser.toUpperCase())) {
            case CHROME -> new ChromeDriver(buildChromeOptions());
            case FIREFOX -> new FirefoxDriver(buildFirefoxOptions());
            default -> throw new IllegalStateException("Invalid browser name: " + browser);
        };
    }

    private ChromeOptions buildChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        return options;
    }

    private FirefoxOptions buildFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("signon.rememberSignons", false);
        options.addPreference("signon.autofillForms", false);
        options.addPreference("signon.autofillForms.http", false);
        options.addPreference("signon.generation.enabled", false);
        options.addPreference("extensions.formautofill.addresses.enabled", false);
        options.addPreference("extensions.formautofill.creditCards.enabled", false);
        return options;
    }

}
/*
// Initialize the ChromeDriver with the configured options
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
 */
/*
public WebDriver initializeDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser");
        driver = switch (browser) {
            case "Chrome" -> {
                // Create ChromeOptions object
                ChromeOptions options = new ChromeOptions();

                // Add the preference to disable password leak detection
                Map<String, Object> prefs = new HashMap<>();
                //prefs.put("profile.password_manager_leak_detection", false); //chrome password manager popup ı için
                //prefs.put("autofill.profile_enabled", false); //stale element hatası için eklendi
                options.setExperimentalOption("prefs", prefs);
                yield new ChromeDriver(options);
            }
            case "Firefox" -> new FirefoxDriver();
            default -> throw new IllegalStateException("Invalid browser name: " + browser);
        };



        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
 */
