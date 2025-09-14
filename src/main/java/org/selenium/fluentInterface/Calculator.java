package org.selenium.fluentInterface;

//Burada method chaining var (add → multiply → getResult).
//Ama cümle gibi “akıcı” okunmuyor; daha çok programcı gözüyle işlem sıralaması.
//ama fluent değil
public class Calculator {
    private int value = 0;

    public Calculator add(int number) {
        value += number;
        return this;
    }

    public Calculator multiply(int number) {
        value *= number;
        return this;
    }

    public int getResult() {
        return value;
    }
}
