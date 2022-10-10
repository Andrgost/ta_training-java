package com.epam.training.aleksandr_gostev.fundamentals.main_task;

import java.time.Month;
import java.util.Scanner;

public class MonthByNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int monthNumber = scanner.nextInt();

        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Month number cannot be less 1 or more 12");
        } else {
            System.out.println(Month.of(monthNumber));
        }

        scanner.close();
    }
}
