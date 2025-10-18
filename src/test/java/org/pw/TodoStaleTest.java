package org.pw;

/*
public class TodoStaleTest extends BaseTest {

    @Test
    void deletingTodoMakesCachedElementStale() {
        driver.get("https://demo.playwright.dev/todomvc/#/");

        WebElement newTodo = driver.findElement(By.cssSelector(".new-todo"));
        newTodo.sendKeys("Task 1", Keys.ENTER);

        // İlk satırı locate edip referansı saklıyoruz
        WebElement firstItem = driver.findElement(By.cssSelector(".todo-list li"));
        WebElement destroyBtn = firstItem.findElement(By.cssSelector("button.destroy"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstItem).perform(); // hover → destroy butonu çıkar

        destroyBtn.click(); // satır DOM'dan kalkıyor

        // Önceden sakladığımız referans artık DOM'da yok → stale bekliyoruz
        //Assert.expectThrows(StaleElementReferenceException.class, firstItem::getText);
        firstItem.getText();
    }

}

 */
