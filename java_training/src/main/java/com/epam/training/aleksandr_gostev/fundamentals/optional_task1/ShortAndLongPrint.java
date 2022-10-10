package com.epam.training.aleksandr_gostev.fundamentals.optional_task1;

import java.util.Scanner;

public class ShortAndLongPrint {
    public static void main(String[] args) {
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

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {

                int currentNumber = numbers[j];
                int currentLength = 0;
                while (Math.abs(currentNumber) >= 1) {
                    currentNumber /= 10;
                    currentLength++;
                }

                int nextNumber = numbers[j + 1];
                int nextLength = 0;
                while (Math.abs(nextNumber) >= 1) {
                    nextNumber /= 10;
                    nextLength++;
                }

                if (currentLength > nextLength) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        //Print in Ascending order
        System.out.println("Numbers in ascending length order:");
        for (int item : numbers) {
            System.out.print(item + " ");
        }

        System.out.println();

        //Print in Descending order
        System.out.println("Numbers in descending length order:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }

        scanner.close();
    }
}
