package com.initialMortgage;

public class MortgageCalculator {
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private int principal;
    private double yearlyInterest;
    private byte periodYears;

    public MortgageCalculator(int principal, double yearlyInterest, byte periodYears) {
        this.principal = principal;
        this.yearlyInterest = yearlyInterest;
        this.periodYears = periodYears;
    }

    public double calculateMortgage() {
        double monthlyInterestPercent = getMonthlyInterest();
        short periodMonths = (short) getTotalNumOfPayments();

        double mortgage = principal * (
                (monthlyInterestPercent * Math.pow(1 + monthlyInterestPercent, periodMonths))
                        / (Math.pow(1 + monthlyInterestPercent, periodMonths) - 1)
        );
        return mortgage;
    }

    public double calcRemainingBalance(int numPaymentsPaid) {
        short totalNumOfPayments = (short) (getTotalNumOfPayments());
        double monthlyInterestPercent = getMonthlyInterest();
        double remainingBalance =
                (principal *
                        (Math.pow(1 + monthlyInterestPercent, totalNumOfPayments) - Math.pow(1 + monthlyInterestPercent, numPaymentsPaid))
                )
                        / (Math.pow(1 + monthlyInterestPercent, totalNumOfPayments) - 1);
        return remainingBalance;
    }

    private short getTotalNumOfPayments() {
        return (short)(periodYears * MONTHS_IN_YEAR);
    }

    private double getMonthlyInterest() {
        return (yearlyInterest / PERCENT) / MONTHS_IN_YEAR;
    }

    public byte getPeriodYears() {
        return periodYears;
    }
}
