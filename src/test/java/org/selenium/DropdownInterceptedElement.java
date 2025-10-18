package org.selenium;

/*
public class DropdownInterceptedElement {
    @Test
    public void elementIntercepted() {
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com/");
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("webtechs");
        WebElement searchButton = driver.findElement(By.cssSelector("div.FPdoLc input.gNO89b"));
        //searchButton.click();
        searchButton.sendKeys(Keys.ENTER);
    }
    @Test
    public void interceptedElement() {
        WebDriver driver = new ChromeDriver();
// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://omayo.blogspot.com/");
       driver.findElement(By.id("blogsmenu")).click();
      // driver.findElement(By.id("selenium143")).click();
       driver.findElement(By.id("selenium143")).sendKeys(Keys.ENTER);
    }
    @Test
    public void test2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://generator.ninja/games/random-cards/");
        //driver.findElement(By.id("rcc-confirm-button")).click();
        WebElement card = driver.findElement(By.cssSelector("div.Layout-module--fullWidthContainer--3uZQa button.Button-module--btn--2EgyS.Button-module--light--3Kmte[type='button']"));
        card.click();
    }
    @Test
    public void test3() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://generator.ninja/games/random-cards/");

        // Hedef buton
        WebElement cardBtn = driver.findElement(By.cssSelector(
                "div.Layout-module--fullWidthContainer--3uZQa button.Button-module--btn--2EgyS.Button-module--light--3Kmte[type='button']"));

        // Merkez pikselde ölçüm yapabilmek için görünümü ortala
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});", cardBtn);

        // JS ile: click noktası, noktadaki katman yığını, Accept rect'i ve örtüyor mu?
        Object diag = ((JavascriptExecutor)driver).executeScript(
                "var btn = arguments[0];" +
                        "var r = btn.getBoundingClientRect();" +
                        "var cx = Math.round(r.left + r.width/2);" +
                        "var cy = Math.round(r.top + r.height/2);" +
                        "var stack = Array.from(document.elementsFromPoint(cx,cy)).slice(0,10)" +
                        "  .map(e=>({tag:e.tagName,id:e.id,class:e.className," +
                        "            z:getComputedStyle(e).zIndex,pe:getComputedStyle(e).pointerEvents}));" +
                        "var acc = document.getElementById('rcc-confirm-button');" +
                        "var ar = acc ? acc.getBoundingClientRect() : null;" +
                        "var cover = ar ? (cx>=ar.left && cx<=ar.right && cy>=ar.top && cy<=ar.bottom) : null;" +
                        "return {clickPoint:{x:cx,y:cy}, elementsAtPoint:stack," +
                        "        acceptRect: ar && {left:Math.round(ar.left),top:Math.round(ar.top),right:Math.round(ar.right),bottom:Math.round(ar.bottom)}," +
                        "        acceptCoversClick: cover};",
                cardBtn
        );
        System.out.println("[DIAG] " + diag);
        // buton merkezini yazdırdık; +21px aşağıyı da yazdır:
        Object stack586 = ((JavascriptExecutor)driver).executeScript(
                "const cx=arguments[1], cy=arguments[2];" +
                        "return Array.from(document.elementsFromPoint(cx,cy)).slice(0,6)" +
                        ".map(e=>({tag:e.tagName,id:e.id,class:e.className,html:e.outerHTML.slice(0,80)}));",
                null, 600, 586
        );
        System.out.println("elementsFromPoint @(600,586): " + stack586);

        // Intercept varsa burada exception fırlar; yoksa tıklama geçer.
        cardBtn.click();

        // (İstersen) test bitiminde kapat
        driver.quit();
    }
}


 */