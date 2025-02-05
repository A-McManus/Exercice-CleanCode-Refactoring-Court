package com.github.glo2003.payroll;

public class SalariedEmployee extends Employee {
    private float biweekly;

    public SalariedEmployee(String name, String role, int AmountVacationDays, float aBiweekly) {
        super(name, role, AmountVacationDays);
        this.biweekly = aBiweekly;
    }

    public float getBiweekly() {
        return biweekly;
    }

    public void setBiweekly(float biweekly) {
        this.biweekly = biweekly;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" + "name='" + this.getName() + '\'' + ", role='" + this.getRole() + '\'' +
                ", vacation_days=" + this.getVacationDays() + ", monthly=" + biweekly + '}';
    }
}
