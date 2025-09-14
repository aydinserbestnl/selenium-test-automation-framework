package org.selenium.fluentInterface;

public class Main {
    public static void main(String[] args) {
        // Fluent interface ile zincirleme kullanım
        Car car = new Car()
                .setColor("Red")
                .setModel("BMW")
                .setYear(2025);

        // Sonuçları yazdır
        car.printInfo();

        int result = new Calculator()
                .add(5)
                .multiply(10)
                .getResult();

        System.out.println(result); // 50

        new ShoppingFlow().goToStore()
                .addItem("apple")
                .placeOrder()
                .proceedToCheckout();
    }
}
