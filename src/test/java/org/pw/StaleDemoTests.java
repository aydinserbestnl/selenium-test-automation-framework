package org.pw;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class StaleDemoTests extends BaseTest {
    private static final String DEMO_URL = "http://localhost:8080/stale-demo.html";
    WebDriverWait wait;
    @BeforeMethod
    void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(DEMO_URL);
    }
    @Test
    void textUpdateOnly_genericAssertionFails() {
        driver.findElement(By.id("btn-text")).click();

        WebElement title = driver.findElement(By.id("title"));
        // Bekleme yok; metin hâlâ "Loading..." iken okuyoruz
        String text = title.getText();

        Assert.assertTrue(
                text.contains("Results ready"),
                "Beklenen metni bulamadık, okunan değer: " + text
        );
        // Bu test 3 sn gecikme nedeniyle AssertionError fırlatır.
    }

    @Test
    void nodeReplaced_cachedElementBecomesStale() {
        WebElement title = driver.findElement(By.id("title"));
        driver.findElement(By.id("btn-replace")).click();

        // DOM eski node'u kaldırana kadar bekle
        // StalenessOf ile eski WebElement’in artık DOM’da olmadığını (node’un değiştiğini) doğruluyoruz.
// Bu noktadan sonra cached referansla yapılacak her getText çağrısı stale hatası üretmeli.

        wait.until(ExpectedConditions.stalenessOf(title));
        // 👉 Bu satır testin asıl kanıtı: eski referansla getText() çağırınca
        //    gerçekten StaleElementReferenceException fırlatmasını bekliyoruz.

        // expectThrows => lambda çalıştırıldığında belirtilen exception fırlarsa test geçer.
// Böylece eski WebElement referansının gerçekten stale hale geldiğini kanıtlamış oluyoruz.

        Assert.expectThrows(StaleElementReferenceException.class, title::getText);

        String refreshed = wait.until(driver -> {
            String text = driver.findElement(By.id("title")).getText();
            return text.contains("node replaced") ? text : null;
        });
        Assert.assertTrue(refreshed.contains("node replaced"));
    }

}
/*
Assert.expectThrows(...) TestNG’nin “şu kodu çalıştır,
belirttiğim exception fırlatıyorsa test geçsin” yardımcı metodudur.
Burada title::getText lambda’sı çağrılıyor:

Eğer title.getText() gerçekten StaleElementReferenceException atarsa,
expectThrows bunu beklediği için test o kısmı “başarılı” sayar.
Eğer exception fırlamazsa (örneğin node hâlâ DOM’da ise)
expectThrows testin fail olmasına sebep olur; çünkü beklenen hata gerçekleşmemiş demektir.
Yani satır, title referansının artık geçersiz hale geldiğini kanıtlamak için,
“bu getter artık stale exception üretmeli” şeklinde bilinçli bir kontrol yapıyor.
 */

/*

ExpectedConditions.stalenessOf(element) Selenium’un bekleme yardımcılarından biri.
Parametre olarak verdiğin WebElement referansını izler; o element DOM’dan kaldırıldığında veya
yeni bir node ile değiştirildiğinde koşul “true” olur ve bekleme sona erer.
Kodda:

wait.until(ExpectedConditions.stalenessOf(title));

Bu satır “title WebElement’i artık DOM’da yoksa (yani stale olduysa) devam et” anlamına gelir.
Böylece Assert.expectThrows çağrısına geçtiğimizde
referansın gerçekten bayatladığından emin oluruz;
aksi halde değişim gerçekleşmeden stale beklemek boşa olurdu.
Kısacası stalenessOf, “bu element artık sayfadan ayrıldı mı?” sorusuna
otomatik bekleme sağlayan bir yardımcıdır. Playwright’ta locator’lar aynı işi kendileri yaptığı için
Böyle bir beklemeye çoğu zaman ihtiyaç duymazsın.
 */
