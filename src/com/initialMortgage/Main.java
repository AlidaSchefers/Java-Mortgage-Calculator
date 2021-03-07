package com.initialMortgage;

import java.text.NumberFormat;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float yearlyInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte periodYears = (byte) Console.readNumber("Period (Years): ", 1,30);

        printMortgage(principal, yearlyInterest, periodYears);
        printPaymentSchedule(principal, yearlyInterest, periodYears);
    }

    private static void printMortgage(int principal, float yearlyInterest, byte periodYears) {
        double mortgage = calculateMortgage(principal, yearlyInterest, periodYears);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE"+"\n"+"--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principal, float yearlyInterest, byte periodYears) {
        System.out.println("\n"+"PAYMENT SCHEDULE"+"\n"+"----------------");
        for (short month = 0; month <= periodYears * MONTHS_IN_YEAR; month++)
            System.out.println(NumberFormat.getCurrencyInstance().format(calcRemainingBalance(principal, yearlyInterest, periodYears, month)));
    }

    ;

    public static double calculateMortgage(int principal, double yearlyInterest, byte periodYears) {
        double monthlyInterestPercent = calcMonthlyInterest(yearlyInterest);
        short periodMonths = (short)(periodYears * MONTHS_IN_YEAR);

        double mortgage = principal * (
                (monthlyInterestPercent * Math.pow(1 + monthlyInterestPercent, periodMonths))
                        / (Math.pow(1 + monthlyInterestPercent, periodMonths) - 1)
        );
        return mortgage;
    };

    public static double calcMonthlyInterest(double yearlyInterest) {
        return (yearlyInterest / PERCENT) / MONTHS_IN_YEAR;
    };

    public static double calcRemainingBalance(int principal, double yearlyInterest, byte periodYears, int numPaymentsPaid) {
        short totalNumOfPayments = (short)(periodYears * MONTHS_IN_YEAR);
        double monthlyInterestPercent = calcMonthlyInterest(yearlyInterest);
        double remainingBalance =
                (principal *
                        (Math.pow(1+monthlyInterestPercent, totalNumOfPayments) - Math.pow(1+monthlyInterestPercent, numPaymentsPaid))
                )
                        / (Math.pow(1+monthlyInterestPercent, totalNumOfPayments) - 1);
        return remainingBalance;
    }
}
