package org.example;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question3 question3 = new Question3();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Question 1 - Goods Containers");
            System.out.println("2. Question 2 - Car Parking");
            System.out.println("3. Question 3 - Nested HTML Tags");
            System.out.println("4. Question 4 - Flood Fill");
            System.out.println("5. Question 5 - Java Identifier Count");
            System.out.println("6. Question 6 - Airport Flights");
            System.out.println("7. Question 7 - Stocks Shares Tax");
            System.out.println("8. Question 8 - Multi Company Stocks");
            System.out.println("9. Question 9 - Arithmetic Expression Calculator");
            System.out.println("10. Question 10 - Backtracking through a Maze");
            System.out.println("11. Question 11 - Shortest Distance to City");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 3:
                    System.out.print("Enter the file name containing HTML tags: ");
                    String fileName = scanner.nextLine();
                    question3.processFile(fileName);
                    break;

                case 4:
                    System.out.print("Flood Fill Problem: ");
                    break;

                case 2:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static class Question3 {

        public static boolean areTagsProperlyNested(String[] tags) {
            Stack<String> stack = new Stack<>();

            for (String tag : tags) {
                if (tag.charAt(0) == '<' && tag.charAt(1) != '/') {
                    if (!tag.equals("<br>")) {
                        stack.push(tag);
                    }
                } else if (tag.charAt(0) == '<' && tag.charAt(1) == '/') {
                    if (stack.isEmpty() || !stack.peek().equals("<" + tag.substring(2))) {
                        return false;
                    }
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }

        public void processFile(String fileName) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] tags = line.trim().split("\\s+");

                    if (areTagsProperlyNested(tags)) {
                        System.out.println("The tags are properly nested.");
                    } else {
                        System.out.println("The tags are NOT properly nested.");
                        System.out.println("new");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
