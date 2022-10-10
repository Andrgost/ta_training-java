package com.epam.training.aleksandr_gostev.fundamentals.main_task;

import java.util.Scanner;

public class SumAndMultiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers would you like to enter?");
        int quantity = scanner.nextInt();

        int[] values = new int[quantity];

        System.out.println("Please, enter " + quantity + " integer numbers:");
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        //Sum of values
        int sum = 0;
        for (int item: values) {
            sum += item;
        }
        System.out.println("Sum = " + sum);

        //Multiply of values
        int multiply = 1;
        for (int item: values) {
            multiply *= item;
        }
        System.out.println("Multiply = " + multiply);

        scanner.close();
    }
}
