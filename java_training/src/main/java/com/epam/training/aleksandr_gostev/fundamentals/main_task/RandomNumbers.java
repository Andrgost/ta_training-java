package com.epam.training.aleksandr_gostev.fundamentals.main_task;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter quantity of random number:");
        int quantity = scanner.nextInt();

        int[] numbers = new int[quantity];

        Random randomIntNumber = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = randomIntNumber.nextInt();
        }

        //Print numbers in one line
        System.out.println("Numbers in one line:");
        for (int item: numbers) {
            System.out.print(item + " ");
        }

        //Print numbers each from new line
        System.out.println("\nNumbers in new lines:");
        for (int item: numbers) {
            System.out.println(item);
        }

        scanner.close();
    }
}
