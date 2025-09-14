package org.selenium.fluentInterface;

public class Car {
    private String color;
    private String model;
    private int year;

    // Fluent setter'lar (return this)
    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Car setYear(int year) {
        this.year = year;
        return this;
    }

    // Bilgileri göstermek için yardımcı metod
    public void printInfo() {
        System.out.println("Car Info:");
        System.out.println("  Color: " + color);
        System.out.println("  Model: " + model);
        System.out.println("  Year : " + year);
    }
}
