package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class PetClinicWaitTest {
    private static final String ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik1VZHplZHhGUlZKaS04Z0lTTWRsOSJ9.eyJ0b2tlbl9lbWFpbCI6ImF5ZGluc2VyYmVzdDM0QGdtYWlsLmNvbSIsImlzcyI6Imh0dHBzOi8vYm9uZGFyYWNhZGVteS51cy5hdXRoMC5jb20vIiwic3ViIjoiYXV0aDB8NjdhYzY0ZGI3NmNlZWQ2Y2FmM2RhOGY5IiwiYXVkIjpbImh0dHA6Ly9sb2NhbGhvc3Q6OTk2Ni9wZXRjbGluaWMvYXBpLyIsImh0dHBzOi8vYm9uZGFyYWNhZGVteS51cy5hdXRoMC5jb20vdXNlcmluZm8iXSwiaWF0IjoxNzU4NDg4NzkwLCJleHAiOjE3NTg1NzUxOTAsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwiLCJhenAiOiJjV3NmZHF1Vk4yT2piVWZOM1BWdHFYY1NvdXhQaHp3ZiJ9.QwXATs2QsoCJS6Ol1ER4P9FVWlO8fbFBcsL33ve5reVXmuMIZq0OUvxplSw8qlCh3xHIcAixcNryp1O4gYhdJALjAAJDnbjS7ZlqC4XVYtNIr2A5reLPQC9giTIWkCNa_6KaDQnNXGoe18_xVz1_OwW0c6pe_s95zMvxVHRm3y09tSScA-bUuem1JwqqjNeMZucNI7UwLYekoxblvCGyFXcnIZiMLxR-MbhKKTVnZCWUSh99miAH0O1gJqJdJHymmw5kCs4_E4yaZ2PbjJ42MbeXSOulUEURVExSDuq6yj_ouBxC6xr2Ov36EoVNTcdsfYe7WUqqvnjJD0j2u9iMLA";
    private static final String ID_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik1VZHplZHhGUlZKaS04Z0lTTWRsOSJ9.eyJ0b2tlbl9lbWFpbCI6ImF5ZGluc2VyYmVzdDM0QGdtYWlsLmNvbSIsIm5pY2tuYW1lIjoiYXlkaW5zZXJiZXN0MzQiLCJuYW1lIjoiQXlkaW4iLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvNjUzZjAzYzM5OGRjMmI1ZTc5MzUwYjhmZmZhMzQ0NzE_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZheS5wbmciLCJ1cGRhdGVkX2F0IjoiMjAyNS0wOS0yMVQyMDoxNTo0Mi44MDRaIiwiZW1haWwiOiJheWRpbnNlcmJlc3QzNEBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiaXNzIjoiaHR0cHM6Ly9ib25kYXJhY2FkZW15LnVzLmF1dGgwLmNvbS8iLCJhdWQiOiJjV3NmZHF1Vk4yT2piVWZOM1BWdHFYY1NvdXhQaHp3ZiIsInN1YiI6ImF1dGgwfDY3YWM2NGRiNzZjZWVkNmNhZjNkYThmOSIsImlhdCI6MTc1ODQ4ODc5MCwiZXhwIjoxNzU4NTI0NzkwLCJzaWQiOiJBRDdPUE9GTmh4dUc3cUt0S243dkZfc0JqY0JWQkdHTiIsIm5vbmNlIjoiVlUxVmNVaFlkVU5NVkhFelpXeFlSRmRITkdGSmJrTnhZMDVDTjI4MmVFODRaM0YwWm5OZmNFWlBiUT09In0.hd7IWrsa2gIln8GjnD0OuONzUz3Bv6GMjO9cVnbHshNvaHirIQAm0OpY1uNPOU5XPcpXjMJoAYllr9HfaUZn4_Esrwhe4uY-ALA1LpWhTUPwkGBokobKajPWO57oOcYHe3ZELuPwxo8UMeh25l-LN9nERAv59v8rB3n3-fEWhq7huUpE0HNxmIF9IE6t7uAsXG0ERcP-3NwzFgKqA5K7LRKas_fXGUPjINum3-6hnBysX4T3Cl6TEUudel9yEsL9L7tA2qZKownfAPeqtBINX769MPSZNu8MqcEOV7HJJLukhWtVAzCN3BR7ZxrkMTk6kzP_l1Gw1AhscaMUCmxCFA";

    @Test
    public void apiWait() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://petclinic.bondaracademy.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        driver.findElement(By.id("username")).sendKeys("aydinserbest34@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Sa21342134.");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        By petTypes = By.cssSelector("a[title='pettypes']");
        wait.until(ExpectedConditions.elementToBeClickable(petTypes));
        Thread.sleep(2000);

        // Pet Types sayfasına git
        driver.findElement(By.cssSelector("a[title='pettypes'] span:nth-child(2)")).click();
        Thread.sleep(2000);
        // İlk Edit butonuna tıkla
        WebElement el = driver.findElement(By.id("0")); // ilk input
        System.out.println("attribute: " + el.getAttribute("value"));   // ""
        System.out.println("property : " + el.getDomProperty("value")); // "cat"
        driver.findElement(
                By.cssSelector("#pettypes tbody tr:first-child td:nth-child(2) button:first-child")
        ).click();
        wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.id("name")), "cat"));
        WebElement petValue = driver.findElement(By.id("name"));
       // assertEquals("cat", petValue.getDomProperty("value"));
        assertEquals("cat", petValue.getAttribute("value"));


//
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(name));
//        wait.until(ExpectedConditions.textToBePresentInElementValue(name, "cat"));
//        WebElement el = driver.findElement(name);
//        assertEquals("cat", el.getDomProperty("value"));


    }
}
