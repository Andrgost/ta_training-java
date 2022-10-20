package com.epam.training.aleksandr_gostev.main_task;

import java.util.Scanner;

public class Player {
    public static void main(String[] args) {

        int menuOption;
        DiscManager discManager = new DiscManager();
        CompactDisc compactDisc = new CompactDisc();

        System.out.println("""
                Please, select menu option (1-4):
                1. Write tracks to disc
                2. Count common track time
                3. Sort tracks by style
                4. Find track by time range
                5. Exit""");

        Scanner scanner = new Scanner(System.in);

        do {
            if (compactDisc.getTrackList().size() == 0) {
                System.out.println("Disc is empty. Please, select menu option 1 to write tracks.");
            } else {
                System.out.println("Disc is full :)\n" +
                        "Please, select menu option (1-5)");
            }

            menuOption = scanner.nextInt();

            if (menuOption < 0 || menuOption > 5) {
                System.out.println("Please, select menu option (1-5):\n");
            }

            switch (menuOption) {
                case 1 -> {
                    System.out.println("Menu option 1 is selected.");
                    compactDisc = discManager.burnTracksToDisc();
                }
                case 2 -> {
                    System.out.println("Menu option 2 is selected.");
                    System.out.println("Common track time = " + discManager.countCommonTime(compactDisc) + " sec");
                }
                case 3 -> {
                    System.out.println("Menu option 3 is selected.");
                    discManager.sortTracksByStyle(compactDisc);
                }
                case 4 -> {
                    System.out.println("Menu option 4 is selected.");

                    System.out.println("Please, enter min track length:");
                    int minLength = scanner.nextInt();

                    System.out.println("Please, enter max track length:");
                    int maxLength = scanner.nextInt();

                    System.out.println(discManager.findTrackByTimeRange(compactDisc, minLength, maxLength));
                }
            }
        }
        while (menuOption != 5);

        scanner.close();
    }
}
