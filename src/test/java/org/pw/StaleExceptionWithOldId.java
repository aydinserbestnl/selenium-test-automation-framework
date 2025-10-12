package org.pw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BaseTest;
import org.testng.annotations.Test;

public class StaleExceptionWithOldId extends BaseTest {
    @Test
    public void firstId(){
        driver.get("https://sso.teachable.com/secure/9521/identity/login/otp");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("abc@gmail.com");
        driver.navigate().refresh();
        email.sendKeys("abc@gmail.com");
    }
}
