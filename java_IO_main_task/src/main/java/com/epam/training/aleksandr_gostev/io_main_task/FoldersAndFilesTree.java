package com.epam.training.aleksandr_gostev.io_main_task;

import java.io.*;
import java.util.Objects;

public class FoldersAndFilesTree {

    private static String splitterForFolder = "|-----";
    private static String splitterForFile = "|     ";

    public static void main(String[] args) {

        File file = new File("java_IO_main_task/data_for_test");

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("java_IO_main_task/result_file/result.txt"));
            getFolderFiles(file, bufferedWriter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        File file2 = new File("java_IO_main_task/result_file/result.txt");
        System.out.println("Folders number = " + countFolders(file2.getPath()));
        System.out.println("Files number = " + countFiles(file2.getPath()));
        System.out.println("Average files number in folder = " + averageFilesNumber(file2.getPath()));
        System.out.println("Average file name length = " + averageFileNameLength(file2.getPath()));
    }

    private static void getFolderFiles(File folder) {
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile()) {
                System.out.println(splitterForFile + file.getName());
            }

            if (file.isDirectory()) {
                System.out.println(splitterForFolder + file.getName());
                splitterForFolder = splitterForFile + splitterForFolder;
                getFolderFiles(file);
            }
        }
        splitterForFolder = "|-----";
        splitterForFile = "|     ";
    }

    private static void getFolderFiles(File folder, BufferedWriter bufferedWriter) throws IOException {
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile()) {
                bufferedWriter.write(splitterForFile + file.getName() + "\n");
            }

            if (file.isDirectory()) {
                bufferedWriter.write(splitterForFolder + file.getName() + "\n");
                splitterForFolder = splitterForFile + splitterForFolder;
                getFolderFiles(file, bufferedWriter);
            }
        }
        splitterForFolder = "|-----";
        splitterForFile = "|     ";
    }

    private static int countFolders(String filePath) {
        BufferedReader bufferedReader = null;
        int foldersNumber = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));

            String fileLine;
            String folderSign = "|-----";
            while ((fileLine = bufferedReader.readLine()) != null) {
                if (fileLine.contains(folderSign)) {
                    foldersNumber++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return foldersNumber;
    }

    private static int countFiles(String filePath) {
        BufferedReader bufferedReader = null;
        int filesNumber = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));

            String fileLine;
            String folderSign = "|-----";
            while ((fileLine = bufferedReader.readLine()) != null) {
                if (!fileLine.contains(folderSign) && !fileLine.endsWith("|")) {
                    filesNumber++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return filesNumber;
    }

    private static double averageFilesNumber(String filePath) {
        String folderSign = "|-----";
        double foldersNumber = 0;
        double filesNumber = 0;

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));

            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                if (fileLine.contains(folderSign)) {
                    foldersNumber++;
                }

                if (!fileLine.contains(folderSign) && !fileLine.endsWith("|")) {
                    filesNumber++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return filesNumber / foldersNumber;
    }

    private static double averageFileNameLength(String filePath) {
        String splitterSign = "|-----";
        double nameLengthSum = 0;
        int count = 0;

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));

            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                if (!fileLine.contains(splitterSign)) {
                    int startIndex = fileLine.lastIndexOf(splitterSign) + splitterSign.length();
                    String name = (String) fileLine.subSequence(startIndex, fileLine.length());
                    nameLengthSum += name.length();
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return nameLengthSum / count;
    }
}
