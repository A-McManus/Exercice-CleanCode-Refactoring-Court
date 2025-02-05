package com.github.glo2003.payroll;

public class HourlyEmployee extends Employee {
    private float rate;
    private float amount;

    public HourlyEmployee(String name, String role, int vacationDays, float aRate, float aAmount) {
        super(name, role, vacationDays);
        this.rate = aRate;
        this.amount = aAmount;
    }

    public float getRate() {
        return rate;
    }

    public float getAmount() {
        return amount;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" + "name='" + this.getName() + '\'' + ", role='" + this.getRole() + '\''
                + ", vacation_days=" + this.getVacationDays() + ", hourlyRate=" + this.getRate() + ", amount=" + this.getAmount() + '}';
    }
}