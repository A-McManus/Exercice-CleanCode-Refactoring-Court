package com.github.glo2003.payroll;


public abstract class Employee {
    private String name;
    private String role;
    private int vacationDays;

    public Employee(String name, String role, int amountVacationDays) {
        this.name = name;
        this.role = role;
        this.vacationDays = amountVacationDays;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacation_days) {
        this.vacationDays = vacation_days;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", role='" + role + '\'' + ", vacation_days=" + vacationDays + '}';
    }
}