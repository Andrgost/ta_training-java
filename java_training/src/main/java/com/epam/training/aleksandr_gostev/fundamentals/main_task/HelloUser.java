package com.epam.training.aleksandr_gostev.fundamentals.main_task;

import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.next();

        System.out.println("Hello, " + userName);

        scanner.close();
    }
}
