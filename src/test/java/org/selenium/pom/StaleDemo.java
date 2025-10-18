package org.selenium.pom;

/*
public class StaleDemo extends BaseTest {
    @Test
    public void example(){
        // 💡 Dosya yolunu senin Mac'e göre ayarladık
        String path = "file:///Users/freefree/Desktop/stale-test.html";
        driver.get(path);
        WebElement oldHeading = driver.findElement(By.id("heading"));
        System.out.println("Old heading text: " + oldHeading.getText());
        System.out.println("Old heading hash: " + oldHeading.hashCode());

        driver.findElement(By.id("refreshBtn")).click();

        WebElement newHeading = driver.findElement(By.id("heading"));
        System.out.println("New heading text: " + newHeading.getText());
        System.out.println("New heading hash: " + newHeading.hashCode());

        System.out.println("Are they equal? " + oldHeading.equals(newHeading));

    }
    @Test
    public void example2(){
        // 💡 Dosya yolunu senin Mac'e göre ayarladık
        String path = "file:///Users/freefree/Desktop/stale-test.html";
        driver.get(path);
        WebElement el1 = driver.findElement(By.id("heading"));
        String id1 = ((RemoteWebElement) el1).getId();
        System.out.println("First element id: " + id1);

        driver.findElement(By.id("refreshBtn")).click();

        WebElement el2 = driver.findElement(By.id("heading"));
        String id2 = ((RemoteWebElement) el2).getId();
        System.out.println("Second element id: " + id2);

        System.out.println(id1.equals(id2)); // false → yeni node oluştu

    }
    @Test
    public void example3(){
        String path = "file:///Users/freefree/Desktop/stale-same-node.html";
        driver.get(path);

        // İlk elementi bul
        WebElement el1 = driver.findElement(By.id("heading"));
        String id1 = ((RemoteWebElement) el1).getId();
        System.out.println("First element id: " + id1);
        System.out.println("Text before click: " + el1.getText());

        // Butona tıkla (sadece text değişecek)
        driver.findElement(By.id("refreshBtn")).click();

        // Aynı locator ile yeniden bul
        WebElement el2 = driver.findElement(By.id("heading"));
        String id2 = ((RemoteWebElement) el2).getId();
        System.out.println("Second element id: " + id2);
        System.out.println("Text after click: " + el2.getText());

        // Karşılaştır
        System.out.println("IDs equal? " + id1.equals(id2));
        System.out.println("Elements equal? " + el1.equals(el2));

        driver.quit();
    }
    @Test
    public void example4(){
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.id("cookieChoiceDismiss")).click();

        WebElement el1 = driver.findElement(By.id("ta1"));
        String id1 = ((RemoteWebElement) el1).getId();
        el1.sendKeys("first code is being sent");
        System.out.println("First element id: " + id1);

        // başka sayfaya git
        driver.findElement(By.cssSelector("a[href='http://testwisely.com/demo']")).click();

        // geri dön
        driver.navigate().back();

        // geri dönüşün bittiğini garanti et
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("ta1")));

        // YENİ elementi bul (YENİ referans!)
        WebElement el2 = driver.findElement(By.id("ta1"));
        String id2 = ((RemoteWebElement) el2).getId();
        System.out.println("Second element id: " + id2);


    }
    @Test
    public void example5() {
        driver.get("https://sso.teachable.com/secure/9521/identity/login/otp");
        WebElement email = driver.findElement(By.id("email"));
        String id1 = ((RemoteWebElement) email).getId();
        System.out.println("Before refresh id: " + id1);
        // 🟢 burada sayfayı yeniliyoruz
       // driver.navigate().refresh();
        System.out.println("Before refresh id: " + id1);

        WebElement email2 = driver.findElement(By.id("email"));
        String id2 = ((RemoteWebElement) email2).getId();
        System.out.println("Before refresh id: " + id2);
        email.sendKeys("abc@gmail.com");
        email.clear();

    }
    @Test
    public void example6() {
        driver.get("https://askomdch.com");
        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
        driver.findElement(By.cssSelector("a[aria-label='Add “Anchor Bracelet” to your cart']")).click();
        // 1. Sepet ikonunu bul
        WebElement cartIcon = driver.findElement(By.cssSelector(".ast-cart-menu-wrap .count"));

        // 2. Hover (fareyle bekleme)
        Actions actions = new Actions(driver);
        actions.moveToElement(cartIcon).perform();

        // 3. Hover sonrası Checkout butonuna tıkla
        WebElement checkoutButton = driver.findElement(By.cssSelector("a.button.checkout.wc-forward"));
        checkoutButton.click();
        driver.findElement(By.cssSelector(".showlogin")).click();
        driver.findElement(By.id("username")).sendKeys("john");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.cssSelector("button[value='Login']")).click();
        String text = driver.findElement(By.cssSelector("td[class='product-name']")).getText();
        Assert.assertTrue(text.contains("Anchor"));


    }
    @Test
    public void sauceDemo() {
        driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement select = driver.findElement(By.tagName("select"));
        Select priceDD = new Select(select);
        priceDD.selectByValue("lohi");
        WebElement product = driver.findElement(By.cssSelector(".inventory_item_name"));
        String text = product.getText();
        System.out.println(text);

        priceDD.selectByValue("hilo");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item_name")));
        String selected = priceDD.getFirstSelectedOption().getText();
        System.out.println("Seçili değer: " + selected);
        System.out.println(product.getText());
    }
}

 */
