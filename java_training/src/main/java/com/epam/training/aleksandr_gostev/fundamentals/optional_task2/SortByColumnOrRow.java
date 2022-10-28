package com.epam.training.aleksandr_gostev.fundamentals.optional_task2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortByColumnOrRow {
    public static void main(String[] args) {
        int n;
        int k = -1;
        int[][] matrix;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter matrix size (n):");
        n = scanner.nextInt();
        matrix = new int[n][n];

        //Fill in matrix with random numbers
        System.out.println("Please, enter matrix values range (M):");
        int M = scanner.nextInt();

        Random randomNumber = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = randomNumber.nextInt(M - (-M)) + (-M);
            }
        }

        //Print original matrix
        System.out.println("\nOriginal matrix is:");
        Arrays.stream(matrix).forEach(row -> {
            Arrays.stream(row).mapToObj(column -> column + " ").forEach(System.out::print);
            System.out.println();
        });

        //Enter k element index
        while (k < 0 || k >= matrix.length) {
            System.out.println("\nPlease, enter k element index (between 0 and " + (matrix.length - 1) + "):");
            k = scanner.nextInt();
        }

        //Sort matrix rows by k-column values in ascending
        int[][] matrixSortedRows = matrix.clone();
        for (int iteration = 0; iteration < matrixSortedRows.length - 1; iteration++) {
            for (int row = 0; row < matrixSortedRows.length - 1; row++) {
                if (matrixSortedRows[row][k] > matrixSortedRows[row + 1][k]) {
                    int[] tempMatrix = matrixSortedRows[row + 1];
                    matrixSortedRows[row + 1] = matrixSortedRows[row];
                    matrixSortedRows[row] = tempMatrix;
                }
            }
        }

        //Print matrix sorted by k-column values
        System.out.println("\nResult matrix sorted by " + k + "-column values is:");
        Arrays.stream(matrixSortedRows).forEach(row -> {
            Arrays.stream(row).mapToObj(column -> column + " ").forEach(System.out::print);
            System.out.println();
        });

        //Sort matrix columns by k-row values in ascending
        int[][] matrixSortedColumns = matrix.clone();
        for (int iteration = 0; iteration < matrixSortedColumns[k].length - 1; iteration++) {
            for (int column = 0; column < matrixSortedColumns[k].length - 1; column++) {
                if (matrixSortedColumns[k][column] > matrixSortedColumns[k][column + 1]) {
                    for (int row = 0; row < matrixSortedColumns.length; row++) {
                        int tempNumber = matrixSortedColumns[row][column + 1];
                            matrixSortedColumns[row][column + 1] = matrixSortedColumns[row][column];
                            matrixSortedColumns[row][column] = tempNumber;
                    }
                }
            }
        }

        //Print matrix sorted by k-row values
        System.out.println("\nResult matrix sorted by " + k + "-row values is:");
        for (int[] row : matrixSortedColumns) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
