package org.selenium.hashcode;

import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void guestCheckoutFlow() {
        HomePage home = new HomePage(driver);
        StorePage store = home.goToStore();
    }
}
