package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Scanner scanner = CoffeeMaker.getScanner();
        String action;

        do {
            coffeeMaker.displayAction();
            action = scanner.next();
            coffeeMaker.performAnAction(action);
        } while (!action.equals("exit"));
    }
}
