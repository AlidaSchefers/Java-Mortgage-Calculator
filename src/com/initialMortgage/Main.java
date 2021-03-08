package com.initialMortgage;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float yearlyInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte periodYears = (byte) Console.readNumber("Period (Years): ", 1,30);

        var calculator = new MortgageCalculator(principal, yearlyInterest, periodYears);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
