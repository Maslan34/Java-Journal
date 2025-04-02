package CapstoneProjects.SalaryCalculator;

public class Employee {
    String name;
    float salary;
    int workHours;
    int hireYear;

    public Employee(String name, float salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public float tax() {
        if (salary <= 1000)
            return 0.0f;
        return salary * 0.03f;
    }

    public int bonus() {
        if (workHours > 40)
            return (workHours - 40) * 30;
        return 0;
    }

    public float getFinalSalary() {
        float increasedSalary = salary + raiseSalary();
        return (increasedSalary + bonus()) - tax();
    }

    public float raiseSalary() {
        int yearsWorked = 2021 - hireYear;
        if (yearsWorked >= 20) {
            return salary * 0.15f;
        } else if (yearsWorked < 10) {
            return salary * 0.05f;
        } else {
            return salary * 0.1f;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Salary: " + salary + "\n" +
                "Work Hours: " + workHours + "\n" +
                "Hire Year: " + hireYear + "\n" +
                "Tax: " + tax() + "\n" +
                "Bonus: " + bonus() + "\n" +
                "Salary Increase: " + raiseSalary() + "\n" +
                "Salary with Taxes and Bonuses: " + ((salary + bonus()) - tax()) + "\n" +
                "Total Salary: " + getFinalSalary();
    }

    public static void main(String[] args) {
        Employee kemal = new Employee("kemal", 2000, 45, 1985);
        System.out.println(kemal);
    }


}
