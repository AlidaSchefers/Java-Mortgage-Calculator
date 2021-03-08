package com.initialMortgage;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in); //this is private b/c this is an implementation detail (no other classes will use it)

    public static double readNumber(String prompt, int min, int max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max + ".");
        }
        return value;
    }
}
