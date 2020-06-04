package com.company;

import java.util.Scanner;

public class CoffeeMaker {
    private static final Scanner scanner = new Scanner(System.in);

    private Coffee espresso = Coffee.ESPRESSO;
    private Coffee latte = Coffee.LATTE;
    private Coffee cappuccino = Coffee.CAPPUCCINO;

    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;

    public CoffeeMaker() {
        this.water = 400;
        this.milk = 540;
        this.coffee = 120;
        this.cups = 9;
        this.money = 550;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public void displayAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit)");
    }

    public void performAnAction(String action) {
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                displayIngredients();
                break;
        }
    }

    private void displayIngredients() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money\n");

    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        String product = scanner.next();

        switch (product) {
            case "1":
                if ((water >= espresso.getWater())
                        && (coffee >= espresso.getBeans())
                        && (cups > 0)) {

                    confirmation();
                    water -= espresso.getWater();
                    coffee -= espresso.getBeans();
                    money += espresso.getCost();
                    cups--;
                } else {
                    if (espresso.getWater() > water) {
                        waterAlert();
                    } else if (espresso.getBeans() > coffee) {
                        coffeeAlert();
                    } else {
                        cupAlert();
                    }
                }
                break;
            case "2":
                if ((water >= latte.getWater())
                        && (milk >= latte.getMilk())
                        && (coffee >= latte.getBeans())
                        && (cups > 0)) {

                    confirmation();
                    water -= latte.getWater();
                    milk -= latte.getMilk();
                    coffee -= latte.getBeans();
                    money += latte.getCost();
                    cups--;
                } else {
                    if (latte.getWater() > water) {
                        waterAlert();
                    } else if (latte.getMilk() > milk) {
                        milkAlert();
                    } else if (latte.getBeans() > coffee) {
                        coffeeAlert();
                    } else {
                        cupAlert();
                    }
                }
                break;
            case "3":
                if ((water >= cappuccino.getWater())
                        && (milk >= cappuccino.getMilk())
                        && (coffee >= cappuccino.getBeans())
                        && (cups > 0)) {

                    confirmation();
                    water -= cappuccino.getWater();
                    milk -= cappuccino.getMilk();
                    coffee -= cappuccino.getBeans();
                    money += cappuccino.getCost();
                    cups--;
                } else {
                    if (cappuccino.getWater() > water) {
                        waterAlert();
                    } else if (cappuccino.getMilk() > milk) {
                        milkAlert();
                    } else if (cappuccino.getBeans() > coffee) {
                        coffeeAlert();
                    } else {
                        cupAlert();
                    }
                }
                break;
            case "back":
                break;
        }
    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        int newWater = scanner.nextInt();
        water += newWater;

        System.out.println("Write how many ml of milk do you want to add:");
        int newMilk = scanner.nextInt();
        milk += newMilk;

        System.out.println("Write how many grams of coffee beans do you want to add:");
        int newCoffee = scanner.nextInt();
        coffee += newCoffee;

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int newCups = scanner.nextInt();
        cups += newCups;
    }

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void waterAlert() {
        System.out.println("Sorry, not enough water!\n");
    }

    private void milkAlert() {
        System.out.println("Sorry, not enough milk!\n");
    }

    private void coffeeAlert() {
        System.out.println("Sorry, not enough coffee beans!\n");
    }

    private void cupAlert() {
        System.out.println("Sorry, not enough cups!\n");
    }

    private void confirmation() {
        System.out.println("I have enough resources, making you a coffee!\n");

    }
}
