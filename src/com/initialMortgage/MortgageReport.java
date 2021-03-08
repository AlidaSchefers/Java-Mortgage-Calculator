package com.initialMortgage;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println("\n" + "PAYMENT SCHEDULE" + "\n" + "----------------");
        for (short month = 0; month <= calculator.getPeriodYears() * MortgageCalculator.MONTHS_IN_YEAR; month++)
            System.out.println(NumberFormat.getCurrencyInstance().format(calculator.calcRemainingBalance(month)));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE" + "\n" + "--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
