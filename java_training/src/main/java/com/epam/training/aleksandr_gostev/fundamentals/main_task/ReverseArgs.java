package com.epam.training.aleksandr_gostev.fundamentals.main_task;

import java.util.Scanner;

public class ReverseArgs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers would you like to enter?");
        int quantity = scanner.nextInt();

        int[] values = new int[quantity];

        System.out.println("Please, enter " + quantity + " integer numbers:");
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        for (int j = values.length - 1; j >= 0; j--) {
            System.out.print(values[j] + " ");
        }

        scanner.close();
    }
}
