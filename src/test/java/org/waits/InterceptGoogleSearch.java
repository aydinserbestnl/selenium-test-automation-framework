package org.waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Map;

public class InterceptGoogleSearch {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        try {
            driver.get("file:///Users/freefree/Desktop/untitled.html");

            WebElement btn = driver.findElement(By.id("go"));

            try {
                btn.click(); // burada overlay varken Exception fırlayacak
            } catch (ElementClickInterceptedException ex) {
                System.out.println("Beklenen hata: " + ex.getClass().getSimpleName());

                // Buton merkez koordinatları
                Rectangle r = btn.getRect();
                long centerX = Math.round(r.getX() + r.getWidth() / 2.0);
                long centerY = Math.round(r.getY() + r.getHeight() / 2.0);

                JavascriptExecutor js = (JavascriptExecutor) driver;

                Object obj = js.executeScript(
                        "var el = document.elementFromPoint(arguments[0], arguments[1]);" +
                                "if(!el) return null;" +
                                "return {tag: el.tagName, id: el.id, class: el.className, text: el.textContent && el.textContent.trim().slice(0,50)};",
                        centerX, centerY
                );

                @SuppressWarnings("unchecked")
                Map<String, Object> info = (Map<String, Object>) obj;
                System.out.println("Önde tıklamayı yakalayan: " + info);

                // Overlay’i kaldırıp tekrar dene:
                js.executeScript("var ov=document.getElementById('overlay'); if(ov) ov.remove();");
                btn.click();
                System.out.println("Tıklama overlay kalkınca başarılı.");
            }

        } finally {
            driver.quit();  // en dıştaki try için finally bloğu
        }
    }
}

