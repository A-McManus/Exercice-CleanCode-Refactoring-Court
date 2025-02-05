package com.github.glo2003.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CompanyPayroll {
    final private List<Employee> employeeList;
    private List<Paycheck> paycheckList;
    private List<Boolean> hasTakenHolidays; // who takes holidays

    public CompanyPayroll() {
        this.employeeList = new ArrayList<>();
        this.paycheckList = new ArrayList<>();
        hasTakenHolidays = new ArrayList<>();
    }

    public void processPending() {
        IntStream.range(0, this.paycheckList.size()).forEach((i) -> this.hasTakenHolidays.set(i, false));
        for (int i = 1; i <= this.paycheckList.size(); ++i) {
            Paycheck p = this.paycheckList.get((i) - 1);
            System.out.println("Sending " + p.getAmount() + "$ to " + p.getTo());
        }
        this.paycheckList.clear();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        this.hasTakenHolidays.add(false);

    }

    public List<Employee> findSoftwareEngineer() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employeeList.size(); ++i) {
            if (employeeList.get(i - 1).getRole().equals("engineer")) {
                es.add(employeeList.get(i - 1));
            }
        }
        return es;
    }

    public List<Employee> findManagers() {
        List<Employee> managers = new ArrayList<>();
        for (int i = 1; i <= employeeList.size(); ++i) {
            if (employeeList.get(i - 1).getRole().equals("manager")) {
                managers.add(employeeList.get(i - 1));
            }
        }
        return managers;
    }

    public List<Employee> findVicePresidents() {
        List<Employee> vicePresidents = new ArrayList<>();
        for (int i = 1; i <= employeeList.size(); ++i) {
            if (employeeList.get(i - 1).getRole().equals("vp")) {
                vicePresidents.add(employeeList.get(i - 1));
            }
        }
        return vicePresidents;
    }

    public List<Employee> findInterns() {
        List<Employee> Interns = new ArrayList<>();
        for (int i = 1; i <= employeeList.size(); ++i) {
            if (employeeList.get(i - 1).getRole().equals("intern")) {
                Interns.add(employeeList.get(i - 1));
            }
        }
        return Interns;
    }

    public void createPending() {
        for (int i = 1; i <= employeeList.size(); ++i) {
            Employee employee = employeeList.get(i - 1);
            if (employee instanceof HourlyEmployee) {
                HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
                paycheckList.add(new Paycheck(employee.getName(), hourlyEmployee.getAmount() * hourlyEmployee.getRate()));
            } else if (employee instanceof SalariedEmployee) {
                paycheckList.add(new Paycheck(employee.getName(), ((SalariedEmployee) employee).getBiweekly()));
            } else {
                throw new RuntimeException("employee type not supported");
            }
        }
    }

    public void RaiseEmployeeSalary(Employee employee, float raiseAmount) {
        if (raiseAmount < 0) {
            throw new RuntimeException("cant decrease an employee salary, raise is negative");
        }
        if (!this.employeeList.contains(employee)) {
            throw new RuntimeException("employee does not exist");
        }
        if (employee instanceof HourlyEmployee) {
            HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
            hourlyEmployee.setRate(hourlyEmployee.getRate() + raiseAmount);
        } else if (employee instanceof SalariedEmployee) {
            SalariedEmployee salariedEmployee = (SalariedEmployee) employee;
            salariedEmployee.setBiweekly(salariedEmployee.getBiweekly() + raiseAmount);
        } else {
            throw new RuntimeException("employee type not supported");
        }
    }

    public float avgPaycheckPending() {
        float averagePaycheckAmount;
        if (this.paycheckList.isEmpty()) {
            return -1f;
        }
        float totalPay = 0.f;
        for (Paycheck paycheckAmount : this.paycheckList) {
            totalPay += paycheckAmount.getAmount();
        }
        averagePaycheckAmount = totalPay / this.paycheckList.size();
        return averagePaycheckAmount;
    }

    public float getTotalMoney() {
        float totalPay = 0.f;
        for (Paycheck paycheckAmount : this.paycheckList) {
            totalPay += paycheckAmount.getAmount();
        }
        return totalPay;
    }

    public List<Paycheck> getPendings() {
        return this.paycheckList;
    }
}