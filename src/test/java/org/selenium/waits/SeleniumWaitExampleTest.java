package org.selenium.waits;
/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWaitExampleTest {
    @Test
    public void checkAddBoxFunction() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        WebElement box = driver.findElement(By.id("box0"));
        Assert.assertTrue(box.isDisplayed());
    }
    @Test
    public void validateWithWait() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("adder")).click();

// Explicit Wait -> box0 görünene kadar bekle
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box0")));

// Artık DOM’da ve görünür, assert geçer
        Assert.assertTrue(box.isDisplayed());
    }
    @Test
    public void checkAddBoxFunctionJunit() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        WebElement box = driver.findElement(By.id("box0"));
       // Assertions.assertTrue(box.isDisplayed(), "Box should be displayed");
    }
    @Test
    public void checkAddBoxFunctionAssertJ() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();

//        List<WebElement> boxes = driver.findElements(By.id("box0"));
//
//        assertThat(boxes)
//                .as("Box list should not be empty after clicking 'Add a box!'")
//                .isNotEmpty();
        WebElement box = driver.findElement(By.id("box0"));
//        assertThat(box.isDisplayed())
//                .as("Box should be visible after clicking 'Add a box!'")
//                .isTrue();
    }
    /*
    Neden .as("...") mesajını göremedin?
	•	Senin kodunda findElement(By.id("box0")) zaten exception fırlatıyor (NoSuchElementException), daha assertThat(...) kısmına bile gelinemiyor.
	•	Yani AssertJ’nin assertion mesajı gösterme şansı olmuyor, çünkü Selenium daha erken patlatıyor.

Bu yüzden konsolda sadece Selenium stack trace’i görüyorsun, .as("...") çalışamıyor.
     */
//}