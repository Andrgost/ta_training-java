package com.epam.training.aleksandr_gostev.fundamentals.optional_task1;

import java.util.Scanner;

public class ShortAndLongNumber {
    public static void main(String[] args) {

        int minNumber = 0;
        int minLength = 0;

        int maxNumber = 0;
        int maxLength = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers would you like to enter?");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Please, enter " + n + " numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("You entered next numbers:");
        for (int item : numbers) {
            System.out.print(item + " ");
        }

        System.out.println();

        for (int item: numbers) {
            int currentNumber = item;
            int length = 0;
            while (Math.abs(currentNumber) >= 1) {
                currentNumber /= 10;
                length++;
            }

            if (minLength == 0) {
                minNumber = item;
                minLength = length;
            }

            if (length < minLength) {
                minNumber = item;
                minLength = length;
            }

            if (length > maxLength) {
                maxNumber = item;
                maxLength = length;
            }
        }

        System.out.println("The shortest number = " + minNumber + ", number length = " + minLength);
        System.out.println("The longest number = " + maxNumber + ", number length = " + maxLength);

        scanner.close();
    }
}
