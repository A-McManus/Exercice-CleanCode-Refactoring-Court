package com.github.glo2003.payroll;

public class Paycheck {
    private String payee;
    private float amount;

    public Paycheck(String whichPayee, float amount) {
        this.payee = whichPayee;
        this.amount = amount;
    }

    public String getTo() {
        return payee;
    }

    public float getAmount() {
        return amount;
    }
}
