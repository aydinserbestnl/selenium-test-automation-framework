package org.pw;

/*
public class ShortVersion extends BaseTest {
    @Test
    public void ifStale() {
        // 1️⃣ Siteye git
        driver.get("https://askomdch.com/");

        // 2️⃣ Store linkine tıkla
        driver.findElement(By.linkText("Store")).click();

        // 3️⃣ Arama kutusuna "Blue" yaz
        driver.findElement(By.name("s")).sendKeys("Blue");

        // 4️⃣ Search butonuna tıkla
        driver.findElement(By.cssSelector("button[value='Search']")).click();

        // 5️⃣ Sayfa başlığını doğrula (doğrudan locate ile)
        Assert.assertEquals(
                driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
                "Search results: “Blue”",
                "Sayfa başlığı beklenenle eşleşmedi!"
        );

        // 6️⃣ Ürünü sepete ekle
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();

        // 7️⃣ View cart linkine tıkla
        driver.findElement(By.cssSelector("a[title='View cart']")).click();

        // 8️⃣ Proceed to checkout linkine tıkla
        driver.findElement(By.cssSelector("a[href*='checkout']")).click();

        // 9️⃣ Place order butonuna tıkla
        driver.findElement(By.cssSelector("button[name='woocommerce_checkout_place_order']")).click();

        // ✅ Test bittiğinde tarayıcıyı kapat
        driver.quit();
    }
}

 */
